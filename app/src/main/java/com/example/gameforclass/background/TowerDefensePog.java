package com.example.gameforclass.background;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;

import com.example.gameforclass.R;
import com.example.gameforclass.antigens.Anthrax;
import com.example.gameforclass.antigens.AntigenType;
import com.example.gameforclass.antigens.Coronavirus;
import com.example.gameforclass.antigens.Rhinovirus;
import com.example.gameforclass.antigens.Staphylococcus;
import com.example.gameforclass.antigens.Tuberculosis;
import com.example.gameforclass.cells.BCell;
import com.example.gameforclass.cells.DendriticCell;
import com.example.gameforclass.cells.Macrophage;
import com.example.gameforclass.cells.TCell;
import com.example.gameforclass.cells.TowerType;
import com.example.gameforclass.activities.TheGameplay;
import com.example.gameforclass.antigens.Antigen;
import com.example.gameforclass.antigens.Aspergillus;
import com.example.gameforclass.antigens.Species;
import com.example.gameforclass.antigens.Pneumococcus;
import com.example.gameforclass.cells.Neutrophil;
import com.example.gameforclass.cells.Tower;
import com.example.gameforclass.cells.UpgradeType;

import java.util.ArrayList;


//TowerDefensePog manages all game objects and logic, and also drawing things to the screen

public class TowerDefensePog extends SurfaceView implements SurfaceHolder.Callback, View.OnTouchListener {

    boolean towerPlacementMode = false;//Tells if we need to draw the grid\
    boolean sellMode = false;
    boolean antiInventoryMode = false;
    boolean placing = false; //Tells if the player is currently selecting(clicking) a square
    boolean firstUpdate = true; //if it's the first time calling update()
    boolean attacked = false; //if a tower is attacking
    boolean cantAfford = false;
    boolean cantPlace = false;
    boolean opacityInc = false;
    boolean pauseGame = true;

    boolean bCellUpgraded = false;

    private float touchX;
    private float touchY;

    int playerHP = 100;
    int playerBiomolecules = 100;

    int enemyRoundCounter = 0;

    int drawTimer = 0; //for drawing the word attack on screen
    int addEnemyTimer = 0; //for having a delay when enemies come on screen
    int cantAffordTimer = 0; //showing text that you cant afford something
    int cantPlaceTimer = 0; //showing text that you cant place something on the path
    int opacityTimer = 100;

    AntigenType invCurrent;

    int tileRows = 13;
    int tileCols = 20;
    int[] pathTilesX, pathTilesY;
    public int screenX = 1440;
    public int screenY = 900; //Size of the FRAGMENT, not the whole screen
    public static int TILE_WIDTH = 70;
    public static int TILE_HEIGHT = 70;

    private Tower[][] towersPlaced;
    private char[][] tiles;//The grid for tower placement; P = Path
    private Species[] set;
    public ArrayList<AntigenType> inventory = new ArrayList<>(); //stores up to 9 captured cells
    private ArrayList<Tower> towers = new ArrayList<>();
    private ArrayList<Antigen> enemies = new ArrayList<>();


    Tower towerWeGonnaPlace = null; //Tower that we gonna place when place tower method called

    //background image of lungs
    private Bitmap background = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.centered_lung), screenX, screenY, false);

    private GameLoop gameLoop;  //Handles drawing the class every frame
    private Context context; //the activity; to use, cast as (TheGameplay)
    private TheGameplay theActivity;
    private Campaign campaign;
    private Paint paint = new Paint(); //guy that paints onto the canvas with colors and font size
    private int cyanColor;

    @RequiresApi(api = Build.VERSION_CODES.N)
    public TowerDefensePog(Context context) {

        super(context);

        cyanColor = ContextCompat.getColor(context, R.color.teal_200);
        this.context = context;
        this.theActivity = (TheGameplay) context;

        this.getHolder().setFixedSize(screenX, screenY);
        setOnTouchListener(this);
        setFocusable(false);


        SurfaceHolder SH = getHolder();
        SH.addCallback(this);

        gameLoop = new GameLoop(this, SH);
        campaign = new Campaign(1);

        towersPlaced = new Tower[tileRows][tileCols];
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

        ArrayList<Integer> tileXList = new ArrayList<>();
        ArrayList<Integer> tileYList = new ArrayList<>();


        for (int y = 0; y < tileRows; y++) {

            for (int x = 0; x < tileCols; x++) {

                if (tiles[y][x] == 'P') {
                    tileYList.add(y);
                    tileXList.add(x);
                }
            }
        }

        pathTilesX = tileXList.stream().mapToInt(x -> x).toArray();
        pathTilesY = tileYList.stream().mapToInt(x -> x).toArray();


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
        if (towerPlacementMode || sellMode || antiInventoryMode) {
            drawGrid(canvas);
            drawPathTiles(canvas);
            if (placing) {
                drawPlaceable(canvas);
            }
        }
        drawEnemies(canvas);
        drawTowers(canvas);


        if (cantAfford) {
            if (cantAffordTimer++ < 50) {
                drawCantAffordText(canvas);
            }
            else {
                cantAffordTimer = 0;
                cantAfford = false;
            }
        }

        if (cantPlace) {
            if (cantPlaceTimer++ < 50) {
                drawCantPlaceText(canvas);
            }
            else {
                cantPlaceTimer = 0;
                cantPlace = false;
            }
        }


        if (attacked) {

            if (drawTimer++ > 20) {
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


        for (int i = 0; i < pathTilesX.length; i++) {
            canvas.drawRect(pathTilesX[i] * TILE_WIDTH, pathTilesY[i] * TILE_HEIGHT, pathTilesX[i] * TILE_WIDTH + TILE_WIDTH, pathTilesY[i] * TILE_HEIGHT + TILE_HEIGHT, paint);
        }

        paint.setAlpha(255);
        paint.setColor(cyanColor);
    }

    public void runOpacityTimer()
    {
        if (opacityInc) {
            if (opacityTimer >= 100) {
                opacityInc = false;
            }
            else opacityTimer += 2;
        } else {
            if (opacityTimer <= 50) {
                opacityInc = true;
            }
            else opacityTimer -= 2;
        }
    }


    public void drawPlaceable(Canvas canvas) {
        paint.setAlpha(opacityTimer);
        canvas.drawRect(touchX - touchX % TILE_WIDTH - TILE_WIDTH, touchY - touchY % TILE_HEIGHT, touchX - touchX % TILE_WIDTH, touchY - touchY % TILE_HEIGHT + TILE_HEIGHT, paint);
        if (towerWeGonnaPlace != null) {
            canvas.drawBitmap(towerWeGonnaPlace.getImage(), touchX - (int) (TILE_WIDTH * 1.5), touchY - TILE_HEIGHT / 2, paint);
        }
        //Rect is trying to highlight the square that it will be placed on when the user lets go
        //xStart, yStart, xEnd, yEnd
        paint.setAlpha(255);
    }

    public void drawBackground(Canvas canvas) { //made this its own method in case we add anything

        paint.setColor(cyanColor);
        canvas.drawBitmap(background, 0, 0, paint);

    }

    public void drawEnemies(Canvas canvas) {

        for (Antigen e : enemies) {
            canvas.drawBitmap(e.getImage(), e.getImageX(), e.getImageY(), paint);
            e.getHealthBar().draw(canvas);
        }


    }

    public void drawTowers(Canvas canvas) {
        for (Tower e : towers) {

            paint.setColor(cyanColor);
            canvas.drawBitmap(e.getImage(), e.getImageX(), e.getImageY(), paint);
            if(e.boost != null)
            {
                switch(e.boost)
                {
                    case FUNGAL:
                        paint.setColor(Color.GREEN);
                        break;
                    case VIRAL:
                        paint.setColor(Color.BLUE);
                        break;
                    case BACTERIAL:
                        paint.setColor(Color.RED);
                        break;
                }
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(5);
                paint.setAlpha(opacityTimer);

                canvas.drawCircle(e.getX() +35 , e.getY() + 35, 50, paint);

                paint.setStyle(Paint.Style.FILL);
                paint.setAlpha(255);
                paint.setStrokeWidth(1);
                paint.setColor(cyanColor);
            }

            if (e.rangeToggleIsOn()) {
                paint.setColor(ContextCompat.getColor(context, R.color.range_highlight_color));
                canvas.drawCircle(e.getX() + 35, e.getY() + 35, e.getRange(), paint);
            }
            if (e.getTowerType() != TowerType.B_CELL) {
                if (e.hasTarget()) {
                    paint.setColor(ContextCompat.getColor(context, R.color.pellet));

                    canvas.drawCircle(e.getAttackPellet().getX(), e.getAttackPellet().getY(), e.getAttackPellet().getSize(), paint);
                }
            } else {
                if (e.hasTarget()) {
                    paint.setColor(ContextCompat.getColor(context, R.color.money));
                    paint.setStrokeWidth(20);
                    paint.setStyle(Paint.Style.STROKE);
                    if (e.getTimerCounter() != 0) {
                        canvas.drawCircle(e.getImageX() + 35, e.getImageY() + 35, (e.getRange() / e.getAttackTimer()) * e.getTimerCounter(), paint);
                    }
                    paint.setStrokeWidth(1);
                    paint.setStyle(Paint.Style.FILL);
                }
            }
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
        if (!pauseGame) {
            if (firstUpdate) //initialize things that I cant initialize in the constructor because the UI hasn't been instantiated yet
            {
                firstUpdate = false;
                theActivity.changeText(playerHP, playerBiomolecules, campaign.getRound() + 1);
            }

            updateEnemies();

        }

        updateTowers();
        runOpacityTimer();
    }

    public void updateInventory()
    {
        int f,v,b;
        f=v=b=0;
        for(int i=0; i < inventory.size(); i++)
        {
            switch(inventory.get(i))
            {
                case VIRAL:
                    if(v==3)
                    {
                        inventory.remove(i);
                        i--;
                    }
                    else v++;
                    break;

                case FUNGAL:
                    if(f==3)
                    {
                        inventory.remove(i);
                        i--;
                    }
                    else f++;
                    break;

                case BACTERIAL:
                    if(b==3)
                    {
                        inventory.remove(i);
                        i--;
                    }
                    else b++;
                    break;
            }
        }
        theActivity.updateInventory(inventory);
    }

    public void updateEnemies() {

        set = campaign.getCurrentArray();

        if (!enemies.isEmpty()) { // move enemies and check if they're dead

            for (int i = 0; i < enemies.size(); i++) {
                Antigen e = enemies.get(i);
                e.move();
                if (e.getHealth() <= 0 || e.pathIsFinished()) {
                    if (e.pathIsFinished()) {//decrease player health if enemy got to the end of the path

                        decHealth(e.getTakeHealth());

                        //TODO make the endscreen
                        if (playerHP == 0) {
                            theActivity.createEndScreen();
                        }


                    } else if (e.getHealth() <= 0) {//add biomolecules to the total amount

                        incBM(e.getBiomolecule());
                        e.actionOnDeath(context, this);
                    }
                    enemies.remove(i);
                    i--;
                }
            }
        }
        if (enemyRoundCounter < set.length) {

            int waitTime = campaign.getWaitTime();

            if (addEnemyTimer >= waitTime) {
                campaign.updateWaitTime();
                if (set[enemyRoundCounter] != null) {
                    addEnemy(set[enemyRoundCounter]);
                    addEnemyTimer = 0;
                } else {
                    addEnemyTimer = waitTime;
                }
                enemyRoundCounter++;
            } else addEnemyTimer++;
        } else if (enemies.isEmpty()) {
            campaign.setNextRound();
            enemyRoundCounter = 0;
            for (Tower t : towers) {
                t.setAttackPellet(null);
            }
            pauseGame();
            theActivity.changeText(playerHP, playerBiomolecules, campaign.getRound() + 1);

        }


    }

    public void updateTowers()
    {
        for (Tower t: towers) {
            if(t.getTowerType() == TowerType.DENDRITIC_CELL)
            {
                ((DendriticCell)t).grabCell(enemies, towers, this);
            }
            else if (t.getTimerCounter() >= t.getAttackTimer() && t.getAttackPellet() == null) {

                if (t.attack(enemies, towers)) {
                    attacked = true;
                    t.setTimerCounter(0);

                }
            } else {
                t.setTimerCounter(t.getTimerCounter() + 1);

                if (t.getAttackPellet() != null) {
                    t.getAttackPellet().move();
                    if (t.getAttackPellet().hasHitEm()) {
                        t.setAttackPellet(null);
                    }
                }
            }
        }
    }

    public void pauseGame() {
        pauseGame = true;
    }

    public void resumeGame() {
        pauseGame = false;
    }

    public void upgrade(UpgradeType upgrade) {

        switch (upgrade) {
            case ANTIBIOTIC:
                Antigen temp = enemies.get((enemies.size() - 1) / 2);
                temp.setVelocity(temp.getVelocity() + 5);
                temp.setHealth(temp.getMaxHealth() * 2);
                temp.setMaxHealth(temp.getHealth());

                enemies.clear();
                enemies.add(temp);
                break;
            case AFFECT_B_CELL:
                if (!bCellUpgraded && canAfford(120)) {
                    decBM(120);
                    bCellUpgraded = true;
                    for (Tower t : towers) {
                        if (t.getTowerType() == TowerType.B_CELL) {
                            Bitmap img = BitmapFactory.decodeResource(this.getResources(), R.drawable.bcelluprgraded);
                            img = Bitmap.createScaledBitmap(img, (int) (this.TILE_WIDTH * 1.4), (int) (this.TILE_HEIGHT * 1.4), false);
                            t.setSizeMultiplier(1.4);
                            t.setImage(img);
                            t.setDmg(t.getDmg() + 20);
                            t.setRange(t.getRange() + 100);
                        }
                    }
                }
                break;
            case FEVER:
                for (Tower t : towers) {
                    t.setRange(t.getRange() + 50);
                    t.setDmg(t.getDmg() + 15);
                }
                break;
            case AFFECT_NAIVE_CELL:
                for (Tower t : towers) {
                    if (t.getTowerType() == TowerType.NAIVE_T_CELL) {
                        t.setDmg(t.getDmg() + 5);
                        t.setRange(t.getRange() + 50);
                    }
                }
                break;
            case BONE_MARROW_UPGRADE:
                for (Tower t : towers) {
                    if (t.getTowerType() == TowerType.MACROPHAGE) {
                        t.setDmg(t.getDmg() + 5);
                        t.setRange(t.getRange() + 50);
                    }
                }
                break;
            case NEUTROPHIL_TRANSFUSION:
                for (Tower t : towers) {
                    if (t.getTowerType() == TowerType.NEUTROPHIL) {
                        t.setDmg(t.getDmg() + 5);
                        t.setRange(t.getRange() + 50);
                    }
                }
                break;
        }
    }

    public void setTowerPlacementMode(TowerType selected) {//initiated by the buttons in the sidebar
        towerPlacementMode = true;

        if (selected == null) return;
        switch (selected) {
            case DENDRITIC_CELL:
                towerWeGonnaPlace = new DendriticCell(0, 0, this);
                if (!canAfford(towerWeGonnaPlace.getBiomolecules())) //if you cant afford the tower
                {
                    towerWeGonnaPlace = null;
                    towerPlacementMode = false;
                    cantAfford = true;
                    return;
                }
                break;
            case B_CELL:
                towerWeGonnaPlace = new BCell(0, 0, this);
                if (!canAfford(towerWeGonnaPlace.getBiomolecules())) //if you cant afford the tower
                {
                    towerWeGonnaPlace = null;
                    towerPlacementMode = false;
                    cantAfford = true;
                    return;
                }
                break;
            case NAIVE_T_CELL:
                towerWeGonnaPlace = new TCell(0, 0, this);
                if (!canAfford(towerWeGonnaPlace.getBiomolecules())) //if you cant afford the tower
                {
                    towerWeGonnaPlace = null;
                    towerPlacementMode = false;
                    cantAfford = true;
                    return;
                }
                break;
            case MACROPHAGE:
                towerWeGonnaPlace = new Macrophage(0, 0, this);
                if (!canAfford(towerWeGonnaPlace.getBiomolecules())) //if you cant afford the tower
                {
                    towerWeGonnaPlace = null;
                    towerPlacementMode = false;
                    cantAfford = true;
                    return;
                }
                break;
            case NEUTROPHIL:
                towerWeGonnaPlace = new Neutrophil(0, 0, this);
                if (!canAfford(towerWeGonnaPlace.getBiomolecules())) //if you cant afford the tower
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
        if (towerWeGonnaPlace != null) {
            towerPlacementMode = false;
            placing = false;
            setFocusable(towerPlacementMode);
            if (!cantPlace) decBM(towerWeGonnaPlace.getBiomolecules());
            towerWeGonnaPlace = null;
        }
        //need to set the placeable bitmap to be connected to selected
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                if (towerPlacementMode || antiInventoryMode) {
                    placing = true;
                }
            case MotionEvent.ACTION_MOVE:
                touchX = event.getX();
                touchY = event.getY();
                break;
            case MotionEvent.ACTION_UP:
                touchX = event.getX();
                touchY = event.getY();

                int yPos = (int) (touchY - touchY % TILE_HEIGHT) / TILE_HEIGHT;
                int xPos = (int) (touchX - touchX % TILE_WIDTH - TILE_WIDTH) / TILE_WIDTH;

                if (yPos >= tileRows || xPos >= tileCols) {
                    if (towerPlacementMode) cantPlace = true;
                    break;
                }
                if (towerWeGonnaPlace != null && towerWeGonnaPlace.getTowerType() != TowerType.DENDRITIC_CELL) {
                    if (tiles[yPos][xPos] == 'P') {
                        cantPlace = true;
                    } else if (towerWeGonnaPlace != null) {
                        towerWeGonnaPlace.setX(xPos * TILE_WIDTH);
                        ; //convert to normal coords
                        towerWeGonnaPlace.setY(yPos * TILE_HEIGHT);
                        addTower(towerWeGonnaPlace);
                        tiles[yPos][xPos] = 'T';
                        towersPlaced[yPos][xPos] = towerWeGonnaPlace;
                    }

                } else if (towerWeGonnaPlace != null) {
                    if (tiles[yPos][xPos] == 'O') {
                        cantPlace = true;
                    } else if (towerWeGonnaPlace != null) {
                        towerWeGonnaPlace.setX(xPos * TILE_WIDTH);
                        ; //convert to normal coords
                        towerWeGonnaPlace.setY(yPos * TILE_HEIGHT);
                        addTower(towerWeGonnaPlace);
                        tiles[yPos][xPos] = 'T';
                        towersPlaced[yPos][xPos] = towerWeGonnaPlace;
                    }
                } else if (sellMode) {
                    if (tiles[yPos][xPos] == 'T') {
                        Tower apoptosis = towersPlaced[yPos][xPos];
                        incBM((int) (apoptosis.getBiomolecules() * 0.5));
                        towers.remove(apoptosis);
                        tiles[yPos][xPos] = 'O';
                    }
                } else if(antiInventoryMode) {
                    if (tiles[yPos][xPos] == 'T') {
                        Tower tow = towersPlaced[yPos][xPos];

                        switch(tow.getTowerType())
                        {
                            case NAIVE_T_CELL:
                                if( !tow.isPhagocyte() ) ((TCell)tow).ascend();
                                break;

                            default:
                                tow.boost = invCurrent;


                        }
                        inventory.remove(invCurrent);
                        theActivity.updateInventory(inventory);

                    }
                    antiInventoryMode = false;
                }

                else if(tiles[yPos][xPos] == 'T') {
                    towersPlaced[yPos][xPos].switchRangeToggle();
                    cantPlace = true;

                }
                endTowerPlacementMode();
                break;
        }
        return true;
    }

    public void addEnemy(Species name) { //one way to add an enemy just by its name


        switch (name) {
            case ANTHRAX:
                enemies.add(new Anthrax(context, this));
                break;
            case RHINOVIRUS:
                enemies.add(new Rhinovirus(context, this));
                break;
            case STAPHYLOCOCCUS:
                enemies.add(new Staphylococcus(context, this));
                break;
            case TUBERCULOSIS:
                enemies.add(new Tuberculosis(context, this));
                break;
            case PNEUMOCOCCUS:
                enemies.add(new Pneumococcus(context, this));
                break;
            case ASPERGILLUS:
                enemies.add(new Aspergillus(context, this));
                break;
            case CORONAVIRUS:
                enemies.add(new Coronavirus(context, this));
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
        if (playerBiomolecules < 0) playerBiomolecules = 0;
        theActivity.changeText(playerHP, playerBiomolecules, campaign.getRound() + 1);
    }

    public void incBM(int antigenGain) {
        playerBiomolecules += antigenGain;
        if (playerBiomolecules > 999999) playerBiomolecules = 999999;
        theActivity.changeText(playerHP, playerBiomolecules, campaign.getRound() + 1);
    }

    public void changeVel(int amount) {
        for (Antigen e : enemies) e.setVelocity(e.getVelocity() + amount);
    }


    //DEV TAB STUFF
    public void incHealth() {
        playerHP += 10;
        if (playerHP > 100) playerHP = 100;
        theActivity.changeText(playerHP, playerBiomolecules, campaign.getRound() + 1);
    }

    public void decHealth(int amount) {
        playerHP -= amount;
        if (playerHP < 30) {
            startAnthraxRoundCountdown();
        }
        if (playerHP < 0) playerHP = 0;
        theActivity.changeText(playerHP, playerBiomolecules, campaign.getRound() + 1);
    }
    //TODO implement anthrax game mechanic
    private void startAnthraxRoundCountdown() {
    }

    public void nextRound() {
        campaign.updateWaitTime(campaign.getCurrentArray().length);
        campaign.setNextRound();
        theActivity.changeText(playerHP, playerBiomolecules, campaign.getRound() + 1);
    }

    public void lastRound() {
        campaign.setPreviousRound();
        campaign.updateWaitTime(-1 * campaign.getCurrentArray().length);
        theActivity.changeText(playerHP, playerBiomolecules, campaign.getRound() + 1);
    }

    public boolean bCellisUpgraded() {
        return bCellUpgraded;
    }

    public void toggleSellMode() {
        sellMode = !sellMode;
    }

    public void addAntigen(AntigenType anti) //adds antigen to a tower
    {
        if(inventory.isEmpty()) return;
        antiInventoryMode = true;
        invCurrent = anti;
    }

}
