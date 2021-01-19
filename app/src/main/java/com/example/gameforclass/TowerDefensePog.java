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

import java.util.ArrayList;


//TowerDefensePog manages all game objects and logic, and also drawing things to the screen

public class TowerDefensePog extends SurfaceView implements SurfaceHolder.Callback {

    public static int TILE_WIDTH = 70;
    public static int TILE_HEIGHT = 70;
    int tileRows, tileCols;

    private char[][] tiles;

    public enum EnemyName {
        PNEUMOCOCCUS,
        ASPERGILLUS,
        HIV
    }

    private Bitmap background; //background image of lungs


    private ArrayList<Enemy> enemies = new ArrayList<>();


    private GameLoop gameLoop;  //Handles drawing the class every frame
    private Context context;
    public int screenX, screenY; //Size of the FRAGMENT, not the whole screen

    private Paint paint = new Paint();

    public TowerDefensePog(Context context) {
        super(context);

        screenX = 1440; screenY = 900;

        this.getHolder().setFixedSize(screenX, screenY);

        background = BitmapFactory.decodeResource(getResources(), R.drawable.straight_up_lungs_bro);
        background = Bitmap.createScaledBitmap(background, screenX, screenY, false);


        SurfaceHolder SH = getHolder();
        SH.addCallback(this);
        this.context = context;

        gameLoop = new GameLoop(this, SH);

        setFocusable(true);

        tileRows = screenY / TILE_HEIGHT; tileCols = screenX / TILE_WIDTH;
        tiles = new char[tileRows][tileCols]; //divide the screen up into tiles

        Aspergillus a = new Aspergillus(this); //Testing, only temporary
        a.x = 500; a.y= 500;

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

        for(Enemy e: enemies) canvas.drawBitmap(e.image, e.x, e.y, paint);

    }

    public void update() { //move things around, logic

        for(Enemy e : enemies)
        {
            if(e.x == 500) e.dx = 10;
            else if(e.x == 1000) e.dx = -10;

            e.x += e.dx;
        }

    }

    public void addEnemy(EnemyName name) { //one way to add an enemy just by its name

        switch(name) {
            case PNEUMOCOCCUS: enemies.add(new Pneumococcus(this)); break;
            case ASPERGILLUS:  enemies.add(new Aspergillus(this)); break;
            case HIV:          enemies.add(new HIV(this)); break;
        }
    }

    public void addEnemy(Enemy e)
    {
        enemies.add(e);
    } //add an enemy by making the object yourself



}
