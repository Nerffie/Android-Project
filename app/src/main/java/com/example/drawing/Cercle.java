package com.example.drawing;

import com.example.emobadaragaminglib.Base.Game;
import com.example.emobadaragaminglib.Base.Image;
import com.example.emobadaragaminglib.Components.Sprite;

public class Cercle extends Sprite {
    /**
     * Constructor
     *
     * @param image  Bitmap of the Sprite
     * @param x      LeftTop Corner X-coordinate from where to start drawing
     * @param y      LeftTop Corner Y-coordinate from where to start drawing
     * @param height Height of the Sprite
     * @param width  Width of the sprite
     */

    Game g;

    public Cercle(Game game,Image image, int x, int y, int height, int width) {
        super(image, x, y, height, width);
        g = game;
    }

    /*public void fill (int x,int y,int color){
        switch (color){
            case 0 :
                MySprite rouge = new MySprite(g,Asset.red_dot,x,y,100,100);
                rouge.setStatic(false);
                g.getCurrentScreen().addSprite(rouge);
                break;
            case 1 :
                MySprite bleu = new MySprite(g,Asset.blue_dot,x,y,100,100);
                bleu.setStatic(false);
                g.getCurrentScreen().addSprite(bleu);
                break;
            case 2 :
                MySprite vert = new MySprite(g,Asset.green_dot,x,y,100,100);
                vert.setStatic(false);
                g.getCurrentScreen().addSprite(vert);
                break;
        }


    }*/
}
