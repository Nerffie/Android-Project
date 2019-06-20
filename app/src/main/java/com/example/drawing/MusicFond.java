package com.example.drawing;

import android.content.Context;
import android.content.Intent;

public class MusicFond {
    private static Intent music = null;

    private MusicFond(Context context) {
        music = new Intent(context, ServiceSon.class);
    }

    synchronized public static Intent getMusic( Context context){
        if ( music == null) {
            new MusicFond(context);
        }
        return music;
    }

}