package com.example.gameforclass.background;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class GameLoop extends Thread{

    TowerDefensePog TDP; //class with the game logic
    SurfaceHolder SH;
    private boolean isRunning = false;
    private boolean cLocked = false;

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

        Canvas canvas = null;
        while(isRunning) {


            //update and render game

            try {

                if(!cLocked)
                {
                    canvas = SH.lockCanvas();
                    cLocked = true;

                    if(canvas != null)
                    {
                        TDP.update();
                        TDP.draw(canvas);
                    }


                }

                if(cLocked)
                {
                    if(canvas != null) SH.unlockCanvasAndPost(canvas);
                    cLocked = false;
                }

                sleep(10);

            } catch (Exception e) {
                e.printStackTrace();
            }




        }
    }
}
