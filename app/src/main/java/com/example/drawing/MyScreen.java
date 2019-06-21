package com.example.drawing;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.util.Log;

import com.example.emobadaragaminglib.Base.Game;
import com.example.emobadaragaminglib.Base.Graphics;
import com.example.emobadaragaminglib.Base.Image;
import com.example.emobadaragaminglib.Base.Screen;
import com.example.emobadaragaminglib.Components.DrawableImage;
import com.example.emobadaragaminglib.Components.Sprite;
import com.example.emobadaragaminglib.Implementation.AndroidGame;
import com.example.emobadaragaminglib.Implementation.AndroidSound;
import com.e_mobadara.audiomanaging.moblibAudioFileManager;
import com.example.drawing.GameActivity;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class MyScreen extends Screen {
    private Background bg;

    private Color red_sprite;
    private Color blue_clair_sprite;
    private Color blue_fonce_sprite;
    private Color green_clair_sprite;
    private Color yellow_sprite;
    private Color rose_sprite;
    private Button reset;
    private Button valider;
    private Button happy_face;
    private Button sad_face;
    private Button wink_face;
    private static int color ;
    private boolean score;
    private int fill;







    public MyScreen(Game game) {

        super(game);

        Asset.red_sprite = game.getGraphics().newImage(R.drawable.rouge,Graphics.ImageFormat.ARGB8888,game.getResources());
        Asset.blue_clair_sprite = game.getGraphics().newImage(R.drawable.bleu_clair,Graphics.ImageFormat.ARGB8888,game.getResources());
        Asset.green_clair_sprite = game.getGraphics().newImage(R.drawable.vert_clair,Graphics.ImageFormat.ARGB8888,game.getResources());
        Asset.yellow_sprite = game.getGraphics().newImage(R.drawable.jaune,Graphics.ImageFormat.ARGB8888,game.getResources());
        Asset.rose_sprite = game.getGraphics().newImage(R.drawable.rose,Graphics.ImageFormat.ARGB8888,game.getResources());


        Asset.valider = game.getGraphics().newImage(R.drawable.valider,Graphics.ImageFormat.ARGB8888,game.getResources());
        Asset.reset = game.getGraphics().newImage(R.drawable.reset,Graphics.ImageFormat.ARGB8888,game.getResources());

        //Asset.happy_face = game.getGraphics().newImage(R.drawable.happy_face,Graphics.ImageFormat.ARGB8888,game.getResources());
        //Asset.sad_face = game.getGraphics().newImage(R.drawable.sad_face,Graphics.ImageFormat.ARGB8888,game.getResources());
        //Asset.wink_face = game.getGraphics().newImage(R.drawable.transparent,Graphics.ImageFormat.ARGB8888,game.getResources());
        //Asset.blank = game.getGraphics().newImage(R.drawable.transparent,Graphics.ImageFormat.ARGB8888,game.getResources());

        // Audio modules imported :




        switch (Asset.LEVEL){
            case 1 : Decor.bg1=game.getGraphics().newImage(R.drawable.carreaux_facile,Graphics.ImageFormat.ARGB8888,game.getResources());break;
            case 2 : Decor.bg1=game.getGraphics().newImage(R.drawable.carreaux_facile,Graphics.ImageFormat.ARGB8888,game.getResources());break;
            case 3 : Decor.bg1= game.getGraphics().newImage(R.drawable.carreaux_difficile,Graphics.ImageFormat.ARGB8888,game.getResources());break;
        }



        bg = new Background(game,Decor.bg1,0,0,game.getGraphics().getHeight(),game.getGraphics().getWidth());

        red_sprite = new Color(game,Asset.red_sprite,0,15,100,100,0);

        blue_clair_sprite = new Color(game,Asset.blue_clair_sprite,150,15,100,100,1);

        green_clair_sprite = new Color(game,Asset.green_clair_sprite,300,15,100,100,3);

        rose_sprite = new Color(game,Asset.rose_sprite,450,15,100,100,4);

        yellow_sprite = new Color(game,Asset.yellow_sprite,600,15,100,100,5);

        reset = new Button(game,Asset.reset,game.getGraphics().getWidth()*91/100,15,150,150);

        valider = new Button(game,Asset.valider,game.getGraphics().getWidth()*78/100,15,150,150);

        //happy_face = new Button(game,Asset.happy_face,game.getGraphics().getWidth()/2,game.getGraphics().getHeight()/2,400,400);

        //sad_face = new Button(game,Asset.sad_face,game.getGraphics().getWidth()/2,game.getGraphics().getHeight()/2,400,400);

        //wink_face = new Button(game,Asset.wink_face,game.getGraphics().getWidth()/2,game.getGraphics().getHeight()/2,400,400);

        score = true;

        color = 0;

        fill = 0;

        addSprite(bg);

        addSprite(red_sprite);

        addSprite(blue_clair_sprite);

        addSprite(green_clair_sprite);

        addSprite(yellow_sprite);

        addSprite(rose_sprite);

        addSprite(reset);

        addSprite(valider);




    }

    @Override
    public void render(float deltaTime) {
        //Graphics g = game.getGraphics();
        //g.drawARGB(255,0,0,0);*


    }

    @Override
    public void handleTouchDown(int x, int y, int pointer) {
        /*
         * In this method I check which Sprite I did touch and act accordingly
         * */
        super.handleTouchDown(x, y, pointer);
        Sprite s = getDraggedSprite();
        if (s != null) {
            if (s.getClass() == Color.class) {
                Color colorSprite = (Color) s;
                MyScreen.color = colorSprite.color;
            }


        }
        if ((valider.contain(x, y))) {
            if (resultat()) {
                //valider bravo;
                try {
                    GameActivity.Winningsound.start();
                } catch (Exception e) {
                    Log.d("Error", "audio file is missing");
                }
                //bravo.setImage(drawing.bravo);
                //again.setImage(drawing.no_color);
                //addSprite(happy_face);
                Timer timer = new Timer();
                TimerTask task = new TimerTask() {
                    @Override
                    public void run() {
                        //bravo.setImage(drawing.no_color);
                    }
                };
                timer.schedule(task, 1500);
                playAudio("goodjob");

                //data to send
                Asset.succes++;
                Asset.date_fin = Calendar.getInstance().getTime();
                long difference = (Asset.date_fin.getTime() - Asset.date_debut.getTime()) / 1000; //sec
                if (Asset.succes == 1) { // first time
                    Asset.min_time = difference;
                } else if (Asset.min_time > difference){
                   Asset.min_time = difference;
                }
                Asset.scores_time.add(difference);

            } else {
                //valider again;
                try {
                    GameActivity.Losingsound.start();
                } catch (Exception e) {
                    Log.d("Error", "audio file is missing");
                }
                //again.setImage(drawing.again);
                //bravo.setImage(drawing.no_color);
                //addSprite(sad_face);

                Timer timer = new Timer();
                TimerTask task = new TimerTask() {
                    @Override
                    public void run() {
                        //again.setImage(drawing.no_color);
                    }
                };
                timer.schedule(task, 1500);
                playAudio("tryagain");

                //data to send
                Asset.fail++;
            }
            //game.setScreen(new MainScreen(game));
            //resume();


        }

        if ((reset.contain(x, y))) {

            reset();
            Asset.date_debut = Calendar.getInstance().getTime();
        }
    }

    private void playAudio(String type) {

        MediaPlayer winning = moblibAudioFileManager.getRandomAudioFile((Context) game, type, Asset.LANG);

        if (winning == null) {
            int id = 0;
            try {
                id = R.raw.class.getField("" + type + "_" + Asset.LANG).getInt(null);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            winning = MediaPlayer.create((Context) game, id);
        }
        winning.start();
    }

    @Override
    public void handleDragging(int x, int y, int pointer) {
        super.handleDragging(x, y, pointer);
        if (y>135) {
            Sprite s;
            s = currentSprite(x, y);
            //s.setStatic(false);
            addSprite(s);
            fill++;
           score(Asset.LEVEL, x ,y);
        }
    }

    private Sprite currentSprite(int x,int y) {

        switch (color){
            case 0 : return new Color(game,Asset.red_sprite,x,y,100,100,0);
            case 1 : return new Color(game,Asset.blue_clair_sprite,x,y,100,100,1);
            case 3 : return new Color(game,Asset.green_clair_sprite,x,y,100,100,3);
            case 4 : return new Color(game,Asset.rose_sprite,x,y,100,100,4);
            case 5 : return new Color(game,Asset.yellow_sprite,x,y,100,100,5);
        }

        return null;
    }

    private boolean validate (){
        return false;
    }

    private void reset(){
        dispose();
        ((GameActivity) game).perviousClicked();

    }

    public void score(int level,int x ,int y){
        switch(level){
            case 1 : level1(x,y);break;
            case 2 : level2(x,y);break;
            case 3 : level3(x,y);break;
        }
    }

    public void level1(int x,int y){

        if(x<game.getGraphics().getWidth()*4/100 || x>game.getGraphics().getWidth()*95/100 || y>game.getGraphics().getHeight()*86/100 || (x>game.getGraphics().getWidth()*43/100 && x<game.getGraphics().getWidth()*56/100) ){
            score=false;
            //Log.i("Aie","Aie");
        }
        Log.i("fill",Integer.toString(fill));


    }

    public boolean resultat(){
        switch (Asset.LEVEL){
            case 1 :
                if (fill>200 && score)return true;
                return false;


            case 2 :
                if(fill>400 && score)return true;
                return false;


            case 3 :
                if (fill >150 && score)return true;
                return false;

        }
        return false;
    }

    public void level2(int x,int y){
        if(x<game.getGraphics().getWidth()*6/100 || x>game.getGraphics().getWidth()*93/100 || y>game.getGraphics().getHeight()*75/100 || (x>game.getGraphics().getWidth()*38/100 && x<game.getGraphics().getWidth()*58/100) ){
            score=false;
            //Log.i("Aie","Aie");
        }
        Log.i("fill",Integer.toString(fill));

    }
    public void level3(int x,int y){

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void backButton() {

    }
}
