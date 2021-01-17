package com.example.gameforclass;

import android.graphics.Canvas;
import android.view.Surface;
import android.view.SurfaceHolder;

public class GameLoop extends Thread{

    TowerDefensePog TDP; //class with the game logic
    SurfaceHolder SH;
    private boolean isRunning = false;

    public GameLoop(TowerDefensePog TDP, SurfaceHolder SH) {
        this.TDP = TDP;
        this.SH = SH;
    }

    public void startLoop() {  //called in SurfaceCreated() in TowerDefensePog class
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
                canvas = SH.lockCanvas(); //grab the canvas to draw on it
                TDP.update();
                TDP.draw(canvas);
                SH.unlockCanvasAndPost(canvas); //let the canvas go and be rendered
                
            } catch (Exception e) {
                e.printStackTrace();
            }




        }
    }
}
