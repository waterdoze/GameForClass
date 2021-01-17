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


//TowerDefensePog manages all game objects and logic, and also drawing things to the screen

public class TowerDefensePog extends SurfaceView implements SurfaceHolder.Callback {

    private Bitmap background; //background image of lungs

    private Bitmap virus; //temporary enemy guy moving around
    private int virusX = 500;
    private int virusY = 500;
    private int virusVelocity = 0;  // we need to put all of this into an enemy class

    private GameLoop gameLoop;  //Handles drawing the class every frame
    Context context;
    int screenX, screenY;

    Paint paint = new Paint();

    public TowerDefensePog(Context context, int screenX, int screenY) {
        super(context);

        this.screenX = screenX; this.screenY = screenY;

        background = BitmapFactory.decodeResource(getResources(), R.drawable.straight_up_lungs_bro);
        background = Bitmap.createScaledBitmap(background, screenX, screenY, false);

        virus = BitmapFactory.decodeResource(getResources(), R.drawable.cholera_easy_mode);
        virus = Bitmap.createScaledBitmap(virus, 120, 120, false);

        SurfaceHolder SH = getHolder();
        SH.addCallback(this);
        this.context = context;

        gameLoop = new GameLoop(this, SH);

        setFocusable(true);

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


        canvas.drawText("Jeff", 200, 200, paint);

    }

    public void drawEnemies(Canvas canvas) {

        canvas.drawBitmap(virus, virusX, virusY, paint);
    }

    public void update() {
        if(virusX == 500) virusVelocity = 10;
        else if(virusX == 1000) virusVelocity = -10;

        virusX += virusVelocity;
    }
}
