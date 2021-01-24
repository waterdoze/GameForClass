package com.example.gameforclass;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import com.example.gameforclass.activities.TheGameplay;
import com.example.gameforclass.antigens.Antigen;
import com.example.gameforclass.antigens.Aspergillus;
import com.example.gameforclass.antigens.HIV;
import com.example.gameforclass.antigens.Pneumococcus;
import com.example.gameforclass.cells.Neutrophil;
import com.example.gameforclass.cells.Tower;

import java.util.ArrayList;


//TowerDefensePog manages all game objects and logic, and also drawing things to the screen

public class TowerDefensePog extends SurfaceView implements SurfaceHolder.Callback, View.OnTouchListener {

    boolean towerPlacementMode;//Tells if we need to draw the grid\
    boolean placing = false; //Tells if the player is currently selecting(clicking) a square
   // private Bitmap placeableImage = new Aspergillus(this).image;//I'm trying to make an image that will follow the finger while the player drags it around
    private float touchX;
    private float touchY;

    boolean firstUpdate = true;

    Tower towerWeGonnaPlace = null; //Tower that we gonna place when place tower method called

    int playerHP = 100;
    int playerBiomolecules = 100;
    int round = 1;

    int drawTimer = 0;
    int addEnemyTimer = 0;

    boolean attacked = false;

    public static int TILE_WIDTH = 70;
    public static int TILE_HEIGHT = 70;
    int tileRows, tileCols;

    private char[][] tiles;//P = Path

    private Bitmap background; //background image of lungs


    private ArrayList<Tower> towers = new ArrayList<>();
    private ArrayList<Antigen> enemies = new ArrayList<>();


    Map map;
    Antigen one;

    private GameLoop gameLoop;  //Handles drawing the class every frame
    private Context context;
    public int screenX, screenY; //Size of the FRAGMENT, not the whole screen

    private Paint paint = new Paint();

    public TowerDefensePog(Context context) {
        super(context);
        //yep cock
        this.context = context;
        screenX = 1440; screenY = 900;
        towerPlacementMode = false; placing = false;

        this.getHolder().setFixedSize(screenX, screenY);
        setOnTouchListener(this);
        setFocusable(false);

        background = BitmapFactory.decodeResource(getResources(), R.drawable.centered_lung);
        background = Bitmap.createScaledBitmap(background, screenX, screenY, false);


        SurfaceHolder SH = getHolder();
        SH.addCallback(this);

        gameLoop = new GameLoop(this, SH);

        tileRows = 12; tileCols = 20;
        tiles = new char[tileRows][tileCols]; //divide the screen up into tiles


    }


    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
        gameLoop.startLoop();
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        drawBackground(canvas);
        if(towerPlacementMode){
            drawGrid(canvas);
            if(placing){
                drawPlaceable(canvas);
            }
        }
        drawEnemies(canvas);
        drawTowers(canvas);

        if(attacked)
        {
            if(drawTimer++ < 20) drawAttack(canvas);
            else
            {
                attacked = false;
                drawTimer = 0;
            }
        }

    }

    public void drawGrid(Canvas canvas) {

        int color = ContextCompat.getColor(context, R.color.teal_200);
        paint.setColor(color);

        for(int i=0; i <= tileRows; i++)
        {
            canvas.drawLine(0, TILE_HEIGHT*i, screenX, TILE_HEIGHT*i, paint); //startX, startY, stopX, stopY, paint
        }
        for(int i=0; i <= tileCols; i++)
        {
            canvas.drawLine(TILE_WIDTH*i, 0, TILE_WIDTH*i, screenY, paint);
        }
    }

    public void drawPlaceable(Canvas canvas){

        if(towerWeGonnaPlace != null) canvas.drawBitmap(towerWeGonnaPlace.image, touchX - TILE_WIDTH, touchY - TILE_HEIGHT, paint);
        canvas.drawRect(touchX - touchX % TILE_WIDTH - TILE_WIDTH, touchY - touchY % TILE_HEIGHT, touchX - touchX % TILE_WIDTH, touchY - touchY % TILE_HEIGHT + TILE_HEIGHT, paint);
        //Rect is trying to highlight the square that it will be placed on when the user lets go
        //xStart, yStart, xEnd, yEnd
    }

    public void drawBackground(Canvas canvas) { //made this it's own method in case we add anything

        canvas.drawBitmap(background, 0, 0, paint);

    }

    public void drawEnemies(Canvas canvas) {

           for(Antigen e: enemies)
           {
               canvas.drawBitmap(e.image, e.posX, e.posY, paint);
               e.getHealthbar().draw(canvas);
           }



    }


    public void drawTowers(Canvas canvas){
        for(Tower e: towers) canvas.drawBitmap(e.image, e.posX, e.posY, paint);
    }

    public void drawAttack(Canvas canvas) {
        int color = ContextCompat.getColor(context, R.color.teal_200);
        paint.setColor(color);
        paint.setTextSize(100);

        canvas.drawText("ATTACKED", 200, 200, paint);
    }

    public void update() { //move things around, logic

        if(firstUpdate) //initialize things that I cant initialize in the constructor because the UI hasn't been instantiated yet
        {
            firstUpdate = false;
            ((TheGameplay)context).changeText(playerHP, playerBiomolecules, round);
        }

        updateEnemies();


        for(Tower t: towers){

            if(t.attackTimer == 50)
            {
                if(t.attack(enemies)) attacked = true;
                t.attackTimer = 0;

            }
            else t.attackTimer++;

        }

    }

    public void updateEnemies()
    {
        if(!enemies.isEmpty())  // move enemies and check if they're dead
        {
            for(int i=0; i < enemies.size(); i++)
            {
                Antigen e = enemies.get(i);
                e.move();
                if(e.getHealth() <= 0 || e.pathFinished)
                {
                    if(e.pathFinished) //decrease player health if enemy got to the end of the path
                    {
                        playerHP -= 1;

                    }
                    else if(e.getHealth() <= 0) //add biomolecules to the total amount
                    {
                        playerBiomolecules += e.getBiomolecule();
                    }
                    enemies.remove(i);
                    i--;

                    ((TheGameplay)context).changeText(playerHP, playerBiomolecules, round); //updates UI text
                }

            }
        }

        if(enemies.size() < 5) //only 5 enemies on screen at a time for now
        {
            if(addEnemyTimer == 20)
            {
                addEnemy(EnemyType.ASPERGILLUS);
                addEnemyTimer = 0;
            }
            else addEnemyTimer++;
        }

    }


    public void setTowerPlacementMode(TowerType selected){//initiated by the buttons in the sidebar
        towerPlacementMode = true;

        if(selected == null) return;
        switch(selected) {
            case NEUTROPHIL:
                towerWeGonnaPlace = new Neutrophil(0,0, this);
                break;
        }
        setFocusable(towerPlacementMode);
        //need to set the placeable bitmap to be connected to selected
    }

    public void endTowerPlacementMode(){//
        towerPlacementMode = false;
        placing = false;
        setFocusable(towerPlacementMode);
        towerWeGonnaPlace = null;

        //need to set the placeable bitmap to be connected to selected
    }

    @Override
    public boolean onTouch(View v, MotionEvent event){
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                placing = true;
            case MotionEvent.ACTION_MOVE:
                touchX = event.getX();
                touchY = event.getY();
                break;
            case MotionEvent.ACTION_UP:
                touchX = event.getX();
                touchY = event.getY();


                if(towerWeGonnaPlace != null)
                {
                    addTower(towerWeGonnaPlace);
                    towerWeGonnaPlace.posX = (int)(touchX - touchX % TILE_WIDTH - TILE_WIDTH);
                    towerWeGonnaPlace.posY = (int) (touchY - touchY % TILE_HEIGHT);
                }
                endTowerPlacementMode();
                break;
        }
        return true;
    }

    public void addEnemy(EnemyType name) { //one way to add an enemy just by its name

        switch(name) {
            case PNEUMOCOCCUS: enemies.add(new Pneumococcus(context, this)); break;
            case ASPERGILLUS:  enemies.add(new Aspergillus(context, this)); break;
            case HIV:          enemies.add(new HIV(context, this)); break;
        }

    }

    public void addEnemy(Antigen e){enemies.add(e);} //add an enemy by making the object yourself

    public void addTower(Tower t){towers.add(t);}// Deez nuts

    public void addTower(int x, int y){//adds based on screen coordinates

    }

}
