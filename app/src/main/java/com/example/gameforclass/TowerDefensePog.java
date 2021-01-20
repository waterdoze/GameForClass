package com.example.gameforclass;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import com.example.gameforclass.antigens.Antigen;
import com.example.gameforclass.cells.Tower;

import java.util.ArrayList;


//TowerDefensePog manages all game objects and logic, and also drawing things to the screen

public class TowerDefensePog extends SurfaceView implements SurfaceHolder.Callback {

    public static int TILE_WIDTH = 70;
    public static int TILE_HEIGHT = 70;
    int tileRows, tileCols;

    private char[][] tiles;

    private Bitmap background; //background image of lungs
    private Bitmap neutro; //neutrophil(temporary)


    private ArrayList<Tower> towers = new ArrayList<>();
    private ArrayList<Antigen> enemies = new ArrayList<>();


    private GameLoop gameLoop;  //Handles drawing the class every frame
    private Context context;
    public int screenX, screenY; //Size of the FRAGMENT, not the whole screen

    private Paint paint = new Paint();

    public TowerDefensePog(Context context) {
        super(context);

        screenX = 1440; screenY = 900;

        this.getHolder().setFixedSize(screenX, screenY);

        background = BitmapFactory.decodeResource(getResources(), R.drawable.centered_lung);
        background = Bitmap.createScaledBitmap(background, screenX, screenY, false);


        SurfaceHolder SH = getHolder();
        SH.addCallback(this);
        this.context = context;

        gameLoop = new GameLoop(this, SH);

        setFocusable(true);

        tileRows = screenY / TILE_HEIGHT; tileCols = screenX / TILE_WIDTH;
        tiles = new char[tileRows][tileCols]; //divide the screen up into tiles

        Antigen a = new Antigen(20, 2, EnemyType.ASPERGILLUS); //Testing, only temporary
        a.screenX = 500; a.screenY= 500;

        Tower t = new Tower(25,25 );

        neutro = BitmapFactory.decodeResource(getResources(), R.drawable.aspergillus);//no neutrophil image I guess... Sadge
        neutro = Bitmap.createScaledBitmap(neutro, 120, 120, false);


        addEnemy(a);

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
        drawGrid(canvas);
        drawEnemies(canvas);

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

    public void drawBackground(Canvas canvas) { //made this it's own method in case we add anything

        canvas.drawBitmap(background, 0, 0, paint);

    }

    public void drawEnemies(Canvas canvas) {

        //for(Antigen e: enemies) canvas.drawBitmap(e.image, e.screenX, e.screenY, paint);

    }

    public void drawTowers(Canvas canvas){
        for(Tower e: towers) canvas.drawBitmap(neutro, e.screenX, e.screenY, paint);
    }

    public void update() { //move things around, logic
//would we call a target method here?
        for(Antigen e : enemies)
        {
            if(e.screenX == 500) e.dx = 10;
            else if(e.screenY == 1000) e.dx = -10;

            e.move();
        }

    }

    public void addEnemy(EnemyType name) { //one way to add an enemy just by its name

//        switch(name) {
//            case PNEUMOCOCCUS: enemies.add(new Pneumococcus(this)); break;
//            case ASPERGILLUS:  enemies.add(new Aspergillus(this)); break;
//            case HIV:          enemies.add(new HIV(this)); break;
//        }
        enemies.add(new Antigen(5,5, EnemyType.ASPERGILLUS));
    }

    public void addEnemy(Antigen e)
    {
        enemies.add(e);
    } //add an enemy by making the object yourself
// Deez nuts


}
