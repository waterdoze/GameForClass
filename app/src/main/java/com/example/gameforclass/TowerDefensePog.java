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

    public enum EnemyName {
        PNEUMOCOCCUS,
        ASPERGILLUS,
        HIV
    }

    private Bitmap background; //background image of lungs



    ArrayList<Enemy> enemies = new ArrayList<>();


    private GameLoop gameLoop;  //Handles drawing the class every frame
    Context context;
    int screenX, screenY;

    Paint paint = new Paint();

    public TowerDefensePog(Context context, int screenX, int screenY) {
        super(context);

        this.screenX = screenX; this.screenY = screenY;

        background = BitmapFactory.decodeResource(getResources(), R.drawable.straight_up_lungs_bro);
        background = Bitmap.createScaledBitmap(background, screenX, screenY, false);



        SurfaceHolder SH = getHolder();
        SH.addCallback(this);
        this.context = context;

        gameLoop = new GameLoop(this, SH);

        setFocusable(true);

        Aspergillus a = new Aspergillus(this);
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
        drawEnemies(canvas);
    }

    public void drawBackground(Canvas canvas) {


        canvas.drawBitmap(background, 0, 0, paint);

        int color = ContextCompat.getColor(context, R.color.teal_200);
        paint.setColor(color);
        paint.setTextSize(50);


    }

    public void drawEnemies(Canvas canvas) {//Should we be using canvas? isn't it outdated and cringe? Am I cringe?

        for(Enemy e: enemies) canvas.drawBitmap(e.image, e.x, e.y, paint);

    }

    public void update() {

        for(Enemy e : enemies)
        {
            if(e.x == 500) e.dx = 10;
            else if(e.x == 1000) e.dx = -10;

            e.x += e.dx;
        }

    }

    public void addEnemy(EnemyName name) {//What the hell are these two methods

        switch(name) {
            case PNEUMOCOCCUS: enemies.add(new Pneumococcus(this)); break;
            case ASPERGILLUS:  enemies.add(new Aspergillus(this)); break;
            case HIV:          enemies.add(new HIV(this)); break;
        }
    }

    public void addEnemy(Enemy e)
    {
        enemies.add(e);
    }

}
