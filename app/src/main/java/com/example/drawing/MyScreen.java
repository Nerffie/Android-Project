package com.example.drawing;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.example.emobadaragaminglib.Base.Game;
import com.example.emobadaragaminglib.Base.Graphics;
import com.example.emobadaragaminglib.Base.Screen;
import com.example.emobadaragaminglib.Components.DrawableImage;
import com.example.emobadaragaminglib.Components.Sprite;
import com.example.emobadaragaminglib.Implementation.AndroidGame;

public class MyScreen extends Screen {

    //private MySprite snake;
    private Background bg;
    //private Cercle cercle1;
    //private Cercle cercle2;
    //private Cercle carre1;
    //private Cercle carre2;
    private Color red_sprite;
    private Color blue_clair_sprite;
    private Color blue_fonce_sprite;
    private Color green_clair_sprite;
    private Color yellow_sprite;
    private Color rose_sprite;
    private Reset reset;
    private static int color ;
    private int score;


    //private DrawableImage drawableCercle1;
    //private DrawableImage drawableCercle2;


    public MyScreen(Game game) {

        super(game);

        //snake = new MySprite(game,Asset.avatar,0,0,100,100);
        switch(Asset.LEVEL){
            case 1 :  bg = new Background(game,Decor.forbidden_zone,Decor.bg1,0,0,game.getGraphics().getHeight(),game.getGraphics().getWidth()); break;
            case 2 :  bg = new Background(game,Decor.forbidden_zone,Decor.bg2,0,0,game.getGraphics().getHeight(),game.getGraphics().getWidth()); break;
            case 3 :  bg = new Background(game,Decor.forbidden_zone,Decor.bg3,0,0,game.getGraphics().getHeight(),game.getGraphics().getWidth()); break;
        }


        //cercle1 = new Cercle(game,Asset.cercle,game.getGraphics().getHeight()/6,game.getGraphics().getWidth()/10,700,700);
        //cercle2 = new Cercle(game,Asset.cercle,6*game.getGraphics().getHeight()/6,game.getGraphics().getWidth()/10,700,700);
        //carre1 = new Cercle(game,Asset.carre,game.getGraphics().getHeight()/6,game.getGraphics().getWidth()/10,700,700);
        //carre2 = new Cercle(game,Asset.carre,6*game.getGraphics().getHeight()/6,game.getGraphics().getWidth()/10,700,700);
        red_sprite = new Color(game,Asset.red_sprite,0,15,100,100,0);

        blue_clair_sprite = new Color(game,Asset.blue_clair_sprite,150,15,100,100,1);

        blue_fonce_sprite = new Color(game,Asset.blue_fonce_sprite,300,15,100,100,2);

        green_clair_sprite = new Color(game,Asset.green_clair_sprite,450,15,100,100,3);

        rose_sprite = new Color(game,Asset.rose_sprite,600,15,100,100,4);

        yellow_sprite = new Color(game,Asset.yellow_sprite,750,15,100,100,5);

        reset = new Reset(game,Asset.reset,game.getGraphics().getHeight()+700,5,150,150);

        score = 0;




        //The drawableImage needs a bitmap. Let's create one from the R.drawable
        //Bitmap mBitmap = BitmapFactory.decodeResource(((AndroidGame)game).getResources(), R.drawable.cercletransparent);

        //Then we use this bitmap as the DrawableImage


        color = 0;
        //snake.setStatic(false);




        //game.getGraphics().drawImage(Asset.bg1,0,0,game.getGraphics().getWidth(),game.getGraphics().getHeight());
        //game.getGraphics().drawImage(Asset.carre,game.getGraphics().getHeight()/6,game.getGraphics().getWidth()/10,700,700);
        //game.getGraphics().drawImage(Asset.carre,6*game.getGraphics().getHeight()/6,game.getGraphics().getWidth()/10,700,700);


        //addSprite(cercle1);
        //addSprite(cercle2);
        //addSprite(carre1);
        //addSprite(carre2);
        addSprite(bg);

        addSprite(red_sprite);

        addSprite(blue_clair_sprite);

        addSprite(blue_fonce_sprite);

        addSprite(green_clair_sprite);

        addSprite(yellow_sprite);

        addSprite(rose_sprite);

        addSprite(reset);

        addSprite(new Color(game,Asset.yellow_sprite,game.getGraphics().getWidth()/2,game.getGraphics().getHeight()*4/100,100,100,5));

        addSprite(new Color(game,Asset.yellow_sprite,game.getGraphics().getWidth()/2,game.getGraphics().getHeight()*95/100,100,100,5));




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
        if(s!=null) {


            /*if (s.getClass() == Cercle.class) {
                Cercle cercle = (Cercle) s;
                cercle.fill(x, y, MyScreen.color);
            }  else*/ if (s.getClass() == Reset.class) {
                Reset resetButton = (Reset) s;
                resetButton.resetGame();
            }
            else if (s.getClass() == Background.class) {
                //play sound
                Background bg = (Background) s;
                bg.play();
            }
            else if (s.getClass() == Color.class) {
                Color colorSprite = (Color) s;
                MyScreen.color = colorSprite.color;
            }
        }


    }

    @Override
    public void handleDragging(int x, int y, int pointer) {
        super.handleDragging(x, y, pointer);
        if (y>135) {
            Sprite s;
            s = currentSprite(x, y);
            //s.setStatic(false);
            addSprite(s);
            if(y<game.getGraphics().getHeight()*4/100|| y>game.getGraphics().getHeight()*95/100){
                score++;
                Log.i("score",Integer.toString(score));

            }
        }
        //Sprite s = getDraggedSprite();
        //Log.i("here","wtf");
        //if(s.getClass()==Cercle.class){
        //    Cercle cercle = (Cercle) s;
        //    cercle.fill(x,y,MyScreen.color);
        //}
    }

    private Sprite currentSprite(int x,int y) {

        switch (color){
            case 0 : return new Color(game,Asset.red_sprite,x,y,100,100,0);
            case 1 : return new Color(game,Asset.blue_clair_sprite,x,y,100,100,1);
            case 2 : return new Color(game,Asset.blue_fonce_sprite,x,y,100,100,2);
            case 3 : return new Color(game,Asset.green_clair_sprite,x,y,100,100,3);
            case 4 : return new Color(game,Asset.rose_sprite,x,y,100,100,4);
            case 5 : return new Color(game,Asset.yellow_sprite,x,y,100,100,5);
        }

        return null;
    }

    private boolean validate (){
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
