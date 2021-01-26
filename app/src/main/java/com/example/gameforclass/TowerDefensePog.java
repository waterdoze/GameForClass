package com.example.gameforclass;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
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
    boolean firstUpdate = true; //if it's the first time calling update()
    boolean attacked = false; //if a tower is attacking
    boolean cantAfford = false;
    boolean cantPlace = false;
    boolean opacityInc = false;

    private float touchX;
    private float touchY;

    private int cyanColor;

    int playerHP = 100;
    int playerBiomolecules = 100;
    int round = 1;
    int drawTimer = 0; //for drawing the word attack on screen
    int addEnemyTimer = 0; //for having a delay when enemies come on screen
    int cantAffordTimer = 0; //showing text that you cant afford something
    int cantPlaceTimer = 0; //showing text that you cant place something on the path
    int opacityTimer = 100;

    int tileRows, tileCols;
    int[] pathTilesX, pathTilesY;

    public int screenX, screenY; //Size of the FRAGMENT, not the whole screen
    public static int TILE_WIDTH = 70;
    public static int TILE_HEIGHT = 70;

    private char[][] tiles;//The grid for tower placement; P = Path
    private ArrayList<Tower> towers = new ArrayList<>();
    private ArrayList<Antigen> enemies = new ArrayList<>();

    Tower towerWeGonnaPlace = null; //Tower that we gonna place when place tower method called

    private Bitmap background; //background image of lungs
    private GameLoop gameLoop;  //Handles drawing the class every frame
    private Context context; //the activity; to use, cast as (TheGameplay)
    private TheGameplay theActivity;
    private Paint paint = new Paint(); //guy that paints onto the canvas with colors and font size



    public TowerDefensePog(Context context) {
        super(context);

        cyanColor = ContextCompat.getColor(context, R.color.teal_200);

        //yep cock
        this.context = context;
        theActivity = (TheGameplay)context;
        screenX = 1440;
        screenY = 900;
        towerPlacementMode = false;
        placing = false;

        this.getHolder().setFixedSize(screenX, screenY);
        setOnTouchListener(this);
        setFocusable(false);

        background = BitmapFactory.decodeResource(getResources(), R.drawable.centered_lung);
        background = Bitmap.createScaledBitmap(background, screenX, screenY, false);


        SurfaceHolder SH = getHolder();
        SH.addCallback(this);

        gameLoop = new GameLoop(this, SH);

        tileRows = 13; tileCols = 20;
        tiles = new char[tileRows][tileCols]; //divide the screen up into tiles

        tiles = new char[][]
                {
                        {'O', 'O', 'O', 'O', 'O', 'P', 'P', 'P', 'O', 'P', 'P', 'O', 'P', 'P', 'P', 'O', 'O', 'O', 'O', 'O'},
                        {'O', 'O', 'O', 'O', 'P', 'P', 'P', 'P', 'O', 'P', 'P', 'O', 'P', 'P', 'P', 'P', 'O', 'O', 'O', 'O'},
                        {'O', 'O', 'O', 'P', 'P', 'P', 'O', 'P', 'P', 'P', 'P', 'P', 'P', 'O', 'P', 'P', 'O', 'O', 'O', 'O'},
                        {'O', 'O', 'O', 'P', 'P', 'O', 'O', 'O', 'P', 'P', 'P', 'P', 'O', 'O', 'O', 'P', 'P', 'O', 'O', 'O'},
                        {'O', 'O', 'P', 'P', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'P', 'P', 'O', 'O'},
                        {'O', 'O', 'P', 'P', 'O', 'O', 'O', 'O', 'P', 'P', 'P', 'P', 'O', 'O', 'O', 'O', 'P', 'P', 'O', 'O'},
                        {'O', 'O', 'P', 'P', 'O', 'O', 'O', 'O', 'P', 'O', 'O', 'P', 'O', 'O', 'O', 'O', 'P', 'P', 'O', 'O'},
                        {'O', 'O', 'P', 'P', 'O', 'O', 'O', 'O', 'P', 'O', 'O', 'P', 'O', 'O', 'O', 'O', 'P', 'P', 'O', 'O'},
                        {'O', 'O', 'P', 'P', 'O', 'O', 'O', 'O', 'P', 'O', 'O', 'P', 'O', 'O', 'O', 'O', 'P', 'P', 'O', 'O'},
                        {'O', 'O', 'P', 'P', 'O', 'O', 'O', 'P', 'P', 'O', 'O', 'P', 'P', 'O', 'O', 'O', 'P', 'P', 'O', 'O'},
                        {'O', 'O', 'P', 'P', 'O', 'O', 'P', 'P', 'P', 'O', 'O', 'P', 'P', 'P', 'O', 'O', 'P', 'P', 'O', 'O'},
                        {'O', 'O', 'P', 'P', 'P', 'P', 'P', 'P', 'O', 'O', 'O', 'O', 'P', 'P', 'P', 'P', 'P', 'P', 'O', 'O'},
                        {'O', 'O', 'O', 'P', 'P', 'P', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'P', 'P', 'P', 'P', 'O', 'O'}

                };


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
        if (towerPlacementMode) {
            drawGrid(canvas);
            drawPathTiles(canvas);
            if (placing) {
                drawPlaceable(canvas);
            }
        }
        drawEnemies(canvas);
        drawTowers(canvas);

        if(cantAfford) {
            if(cantAffordTimer++ < 50) drawCantAffordText(canvas);
            else {
                cantAffordTimer = 0;
                cantAfford = false;
            }
        }

        if(cantPlace) {
            if(cantPlaceTimer++ < 50) drawCantPlaceText(canvas);
            else {
                cantPlaceTimer = 0;
                cantPlace = false;
            }
        }


        if(attacked)
        {

            if(drawTimer++ > 20)
            {
                attacked = false;
                drawTimer = 0;
            }
        }

    }

    public void drawGrid(Canvas canvas) {


        paint.setColor(cyanColor);

        for (int i = 0; i <= tileRows; i++) {
            canvas.drawLine(0, TILE_HEIGHT * i, screenX, TILE_HEIGHT * i, paint); //startX, startY, stopX, stopY, paint
        }
        for (int i = 0; i <= tileCols; i++) {
            canvas.drawLine(TILE_WIDTH * i, 0, TILE_WIDTH * i, screenY, paint);
        }
    }

    public void drawPathTiles(Canvas canvas) {

        paint.setColor(Color.RED);

        paint.setAlpha(opacityTimer);
        if(opacityInc)
        {
            if(opacityTimer >= 100) opacityInc = false;
            else opacityTimer+=2;
        }
        else
        {
            if(opacityTimer <= 50) opacityInc = true;
            else opacityTimer-=2;
        }


        for(int i=0; i < tileRows; i++)
        {
            for(int x=0; x < tileCols; x++)
            {
                if(tiles[i][x] == 'P') canvas.drawRect(x*TILE_HEIGHT, i*TILE_WIDTH, x*TILE_HEIGHT + TILE_HEIGHT, i*TILE_WIDTH + TILE_WIDTH, paint);
            }
        }

       paint.setAlpha(255);
        paint.setColor(cyanColor);
    }

    public void drawPlaceable(Canvas canvas){
        paint.setAlpha(opacityTimer);
        canvas.drawRect(touchX - touchX % TILE_WIDTH - TILE_WIDTH, touchY - touchY % TILE_HEIGHT, touchX - touchX % TILE_WIDTH, touchY - touchY % TILE_HEIGHT + TILE_HEIGHT, paint);
        if(towerWeGonnaPlace != null) canvas.drawBitmap(towerWeGonnaPlace.image, touchX - (int)(TILE_WIDTH * 1.5), touchY - TILE_HEIGHT/2, paint);
        //Rect is trying to highlight the square that it will be placed on when the user lets go
        //xStart, yStart, xEnd, yEnd
        paint.setAlpha(255);
    }

    public void drawBackground(Canvas canvas) { //made this its own method in case we add anything

        canvas.drawBitmap(background, 0, 0, paint);

    }

    public void drawEnemies(Canvas canvas) {

        for (Antigen e : enemies) {
            canvas.drawBitmap(e.image, e.posX, e.posY, paint);
            e.getHealthbar().draw(canvas);
        }


    }


    public void drawTowers(Canvas canvas){
        for(Tower e: towers) {
            canvas.drawBitmap(e.image, e.posX, e.posY, paint);
            if(e.attackPellet!=null)canvas.drawCircle(e.attackPellet.screenX, e.attackPellet.screenY, e.attackPellet.size, paint);
        }
    }

    public void drawCantAffordText(Canvas canvas) {

        paint.setColor(cyanColor);
        paint.setTextSize(100);

        canvas.drawText("YOU CANT AFFORD THAT", 200, 200, paint);
    }

    public void drawCantPlaceText(Canvas canvas) {
        paint.setColor(cyanColor);
        paint.setTextSize(100);

        canvas.drawText("YOU CANT PLACE THERE", 200, 200, paint);
    }


    public void update() { //move things around, logic

        if (firstUpdate) //initialize things that I cant initialize in the constructor because the UI hasn't been instantiated yet
        {
            firstUpdate = false;
            theActivity.changeText(playerHP, playerBiomolecules, round);
        }

        updateEnemies();

        for (Tower t : towers) {


            if(t.attackTimer == 50 && t.attackPellet == null)
            {
                if(t.attack(enemies)){
                    attacked = true;
                    t.attackTimer = 0;
                }

            }
            else {
                t.attackTimer++;
                if(t.attackPellet!=null) {
                    t.attackPellet.move();
                    if (t.attackPellet.hitEm) t.attackPellet = null;
                }
            }

        }

    }

    public void updateEnemies() {
        if (!enemies.isEmpty())  // move enemies and check if they're dead
        {
            for (int i = 0; i < enemies.size(); i++) {
                Antigen e = enemies.get(i);
                e.move();
                if (e.getHealth() <= 0 || e.pathFinished) {
                    if (e.pathFinished) //decrease player health if enemy got to the end of the path
                    {
                        decHealth(5);


                    } else if (e.getHealth() <= 0) //add biomolecules to the total amount
                    {
                        incBM(e.getBiomolecule());
                    }
                    enemies.remove(i);
                    i--;

                }

            }
        }

        if (enemies.size() < 5) //only 5 enemies on screen at a time for now
        {
            if (addEnemyTimer == 5) {
                addEnemy(EnemyType.ASPERGILLUS);
                addEnemyTimer = 0;
            } else addEnemyTimer++;
        }

    }


    public void setTowerPlacementMode(TowerType selected) {//initiated by the buttons in the sidebar

        towerPlacementMode = true;

        if (selected == null) return;
        switch (selected) {
            case NEUTROPHIL:
                towerWeGonnaPlace = new Neutrophil(0, 0, this);
                if(!canAfford(towerWeGonnaPlace.biomolecules)) //if you cant afford the tower
                {
                    towerWeGonnaPlace = null;
                    towerPlacementMode = false;
                    cantAfford = true;
                    return;
                }
                break;
        }
        setFocusable(towerPlacementMode);
        //need to set the placeable bitmap to be connected to selected
    }

    public boolean canAfford(int towerCost) {
        return playerBiomolecules >= towerCost;
    }


    public void endTowerPlacementMode() {//
        towerPlacementMode = false;
        placing = false;
        setFocusable(towerPlacementMode);
        if(!cantPlace) decBM(towerWeGonnaPlace.biomolecules);
        towerWeGonnaPlace = null;

        //need to set the placeable bitmap to be connected to selected
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                placing = true;
            case MotionEvent.ACTION_MOVE:
                touchX = event.getX();
                touchY = event.getY();
                break;
            case MotionEvent.ACTION_UP:
                touchX = event.getX();
                touchY = event.getY();

                int yPos = (int) (touchY - touchY % TILE_HEIGHT);
                int xPos = (int) (touchX - touchX % TILE_WIDTH - TILE_WIDTH);

                if(tiles[yPos / TILE_HEIGHT][xPos / TILE_WIDTH] == 'P')
                {
                    cantPlace = true;
                }

                else if (towerWeGonnaPlace != null) {
                    addTower(towerWeGonnaPlace);
                    towerWeGonnaPlace.posX = xPos;
                    towerWeGonnaPlace.posY = yPos;
                }
                endTowerPlacementMode();
                break;
        }
        return true;
    }

    public void addEnemy(EnemyType name) { //one way to add an enemy just by its name

        
        switch (name) {
            case PNEUMOCOCCUS:
                enemies.add(new Pneumococcus(context, this));
                break;
            case ASPERGILLUS:
                enemies.add(new Aspergillus(context, this));
                break;
            case HIV:
                enemies.add(new HIV(context, this));
                break;
        }

    }

    public void addEnemy(Antigen e) {
        enemies.add(e);
    } //add an enemy by making the object yourself

    public void addTower(Tower t) {
        towers.add(t);
    }// Deez nuts

    public void decBM(int towerCost) {
        playerBiomolecules -= towerCost;
        if(playerBiomolecules < 0) playerBiomolecules = 0;
        theActivity.changeText(playerHP, playerBiomolecules, round);
    }
    public void incBM(int antigenGain) {
        playerBiomolecules += antigenGain;
        if(playerBiomolecules > 999999) playerBiomolecules = 999999;
        theActivity.changeText(playerHP, playerBiomolecules, round);
    }

    public void changeVel(int amount)
    {
        for(Antigen e: enemies) e.velocity += amount;
    }


    //DEV TAB STUFF
    public void incHealth(){
        playerHP+=10;
        if(playerHP > 100) playerHP = 100;
        theActivity.changeText(playerHP, playerBiomolecules, round);
    }
    public void decHealth(int amount) {
        playerHP-=amount;
        if(playerHP < 0) playerHP = 0;
        theActivity.changeText(playerHP, playerBiomolecules, round);
    }
    public void nextRound(){
        round+=1;
        theActivity.changeText(playerHP, playerBiomolecules, round);
    }
    public void lastRound(){
        round-=1;
        theActivity.changeText(playerHP, playerBiomolecules, round);
    }
}
