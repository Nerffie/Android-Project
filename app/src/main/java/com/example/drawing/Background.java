package com.example.drawing;

import com.example.emobadaragaminglib.Base.Game;
import com.example.emobadaragaminglib.Base.Image;
import com.example.emobadaragaminglib.Components.Sprite;
import com.example.emobadaragaminglib.Implementation.AndroidSound;

public class Background extends Sprite {
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
    private AndroidSound error_sound;

    public Background(Game game,AndroidSound sound,Image image, int x, int y, int height, int width) {
        super(image, x, y, height, width);
        error_sound = sound;
        g = game;
    }

    //we leave them static
    public void play(){
        this.error_sound.play(1);
    }

}
