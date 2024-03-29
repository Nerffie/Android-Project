package com.example.drawing.screen;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;

import com.example.drawing.R;
import com.example.drawing.activity.GameActivity;
import com.example.drawing.asset.Asset;
import com.example.drawing.sprites.MySprite;
import com.example.drawing.sprites.Color;
import com.example.emobadaragaminglib.Base.Game;
import com.example.emobadaragaminglib.Base.Graphics;
import com.example.emobadaragaminglib.Base.Screen;
import com.example.emobadaragaminglib.Components.Sprite;
import com.e_mobadara.audiomanaging.moblibAudioFileManager;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class MyScreen extends Screen {
    private MySprite bg;

    private Color red_sprite;
    private Color blue_clair_sprite;
    private Color blue_fonce_sprite;
    private Color green_clair_sprite;
    private Color yellow_sprite;
    private Color rose_sprite;
    private Color current;
    private MySprite reset;
    private MySprite valider;
    private MySprite happy_face;
    private MySprite sad_face;
    private MySprite wink_face;
    private MySprite cercle_noir;
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

        Asset.happy_face = game.getGraphics().newImage(R.drawable.happy_face,Graphics.ImageFormat.ARGB8888,game.getResources());
        Asset.sad_face = game.getGraphics().newImage(R.drawable.sad_face,Graphics.ImageFormat.ARGB8888,game.getResources());
        Asset.wink_face = game.getGraphics().newImage(R.drawable.transparent,Graphics.ImageFormat.ARGB8888,game.getResources());
        Asset.blank = game.getGraphics().newImage(R.drawable.transparent,Graphics.ImageFormat.ARGB8888,game.getResources());

        Asset.cercle_noir = game.getGraphics().newImage(R.drawable.cercle_noir,Graphics.ImageFormat.ARGB8888,game.getResources());

        Asset.marge = new int[4];








        switch (Asset.LEVEL){
            case 1 : Asset.bg=game.getGraphics().newImage(R.drawable.carreaux_facile,Graphics.ImageFormat.ARGB8888,game.getResources());

            Asset.marge[0]=32;
            Asset.marge[1]=63;
            Asset.marge[2]=19;
            Asset.marge[3]=75;

                        break;
            case 2 : Asset.bg=game.getGraphics().newImage(R.drawable.carreaux_facile,Graphics.ImageFormat.ARGB8888,game.getResources());

                Asset.marge[0]=30;
                Asset.marge[1]=63;
                Asset.marge[2]=19;
                Asset.marge[3]=75;
                        break;
            case 3 : Asset.bg= game.getGraphics().newImage(R.drawable.carreaux_difficile,Graphics.ImageFormat.ARGB8888,game.getResources());


                Asset.marge[0]=34;
                Asset.marge[1]=60;
                Asset.marge[2]=25;
                Asset.marge[3]=68;
                        break;
        }



        bg = new MySprite(game,Asset.bg,0,0,game.getGraphics().getHeight(),game.getGraphics().getWidth());

        red_sprite = new Color(game,Asset.red_sprite,0,15,100,100,0);

        blue_clair_sprite = new Color(game,Asset.blue_clair_sprite,150,15,100,100,1);

        green_clair_sprite = new Color(game,Asset.green_clair_sprite,300,15,100,100,3);

        rose_sprite = new Color(game,Asset.rose_sprite,450,15,100,100,4);

        yellow_sprite = new Color(game,Asset.yellow_sprite,600,15,100,100,5);

        reset = new MySprite(game,Asset.reset,game.getGraphics().getWidth()*91/100,15,150,150);

        valider = new MySprite(game,Asset.valider,game.getGraphics().getWidth()*78/100,15,150,150);

        happy_face = new MySprite(game,Asset.blank,game.getGraphics().getWidth()*10/100,game.getGraphics().getHeight()*40/100,400,400);

        sad_face = new MySprite(game,Asset.blank,game.getGraphics().getWidth()*75/100,game.getGraphics().getHeight()*40/100,400,400);

        wink_face = new MySprite(game,Asset.blank,game.getGraphics().getWidth()*40/100,12,400,400);

        current = new Color(game,Asset.red_sprite,game.getGraphics().getWidth()*60/100,12,100,100,0);

        cercle_noir = new MySprite(game,Asset.cercle_noir,game.getGraphics().getWidth()*60/100,12,105,105);

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

        addSprite(happy_face);

        addSprite(sad_face);

        addSprite(current);

        addSprite(cercle_noir);



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
                switch (color){
                    case 0 : current.setImage(Asset.red_sprite);break;
                    case 1 : current.setImage(Asset.blue_clair_sprite); break;
                    case 3 : current.setImage(Asset.green_clair_sprite);break;
                    case 4 : current.setImage(Asset.rose_sprite);break;
                    case 5 : current.setImage(Asset.yellow_sprite);break;
                }
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
                happy_face.setImage(Asset.happy_face);
                //again.setImage(drawing.no_color);
                //addSprite(happy_face);
                Timer timer = new Timer();
                TimerTask task = new TimerTask() {
                    @Override
                    public void run() {
                        happy_face.setImage(Asset.blank);
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

                try {
                    GameActivity.Losingsound.start();
                } catch (Exception e) {
                    Log.d("Error", "audio file is missing");
                }

                sad_face.setImage(Asset.sad_face);

                Timer timer = new Timer();
                TimerTask task = new TimerTask() {
                    @Override
                    public void run() {
                        sad_face.setImage(Asset.blank);
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
        if (y>game.getGraphics().getHeight()*Asset.marge[2]/100 && y < game.getGraphics().getHeight()*Asset.marge[3]/100 && x >game.getGraphics().getWidth()*Asset.marge[0]/100 && x<game.getGraphics().getWidth()*Asset.marge[1]/100) {
            Sprite s;
            s = currentSprite(x, y);
            addSprite(s);
            fill++;
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


    private void reset(){
        dispose();
        ((GameActivity) game).perviousClicked();
    }


    public boolean resultat(){
        switch (Asset.LEVEL){
            case 1 :
                if (fill>Asset.fillPercentage[0])return true;
                return false;


            case 2 :
                if(fill>Asset.fillPercentage[1])return true;
                return false;


            case 3 :
                if (fill >Asset.fillPercentage[2])return true;
                return false;

        }
        return false;
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
