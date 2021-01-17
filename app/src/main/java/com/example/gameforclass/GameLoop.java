package com.example.gameforclass;

import android.graphics.Canvas;
import android.view.Surface;
import android.view.SurfaceHolder;

public class GameLoop extends Thread{

    TowerDefensePog TDP;
    SurfaceHolder SH;
    private boolean isRunning = false;

    public GameLoop(TowerDefensePog TDP, SurfaceHolder SH) {
        this.TDP = TDP;
        this.SH = SH;
    }

    public void startLoop() {
        isRunning = true;
        start();
    }

    @Override
    public void run() {
        super.run();

        Canvas canvas;
        while(isRunning) {


            //update and render game

            try {
                canvas = SH.lockCanvas();
                TDP.update();
                TDP.draw(canvas);
                SH.unlockCanvasAndPost(canvas);
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }
}
