package com.example.drawing;

import com.example.emobadaragaminglib.Base.Game;
import com.example.emobadaragaminglib.Base.Image;
import com.example.emobadaragaminglib.Components.Sprite;

public class Color extends Sprite {
    /**
     * Constructor
     *
     * @param image  Bitmap of the Sprite
     * @param x      LeftTop Corner X-coordinate from where to start drawing
     * @param y      LeftTop Corner Y-coordinate from where to start drawing
     * @param height Height of the Sprite
     * @param width  Width of the sprite
     */
    int color;
    Game g;

    public Color (Game game,Image image, int x, int y, int height, int width,int color) {
        super(image, x, y, height, width);
        g = game;
        this.color=color;
    }
}
