package com.example.drawing;
import android.media.MediaPlayer;
import android.util.Log;

import com.e_mobadara.audiomanaging.moblibAudioFileManager;
import com.example.drawing.Asset;
import com.example.drawing.MyScreen;
import com.example.drawing.R;
import com.example.emobadaragaminglib.Base.Graphics;
import com.example.emobadaragaminglib.Base.Screen;
import com.example.emobadaragaminglib.Implementation.AndroidGame;
import com.example.emobadaragaminglib.Implementation.AndroidSound;

import java.util.Calendar;

public class GameActivity extends AndroidGame {
    private static final String TAG = "GameActivity";
    public static MediaPlayer Losingsound;
    public static MediaPlayer Winningsound;

    @Override
    public Screen getInitScreen() {
        //initAssets();
        //Log.i(TAG, "getInitScreen: Assets are Loaded");
        Losingsound = moblibAudioFileManager.getRandomAudioFile(this,"encouragement","AR");
        Winningsound = moblibAudioFileManager.getRandomAudioFile(this,"good","AR");
        Asset.date_debut = Calendar.getInstance().getTime();
        Asset.date_fin = Calendar.getInstance().getTime();
        return new MyScreen(this);
    }

    @Override
    public void setScreen(Screen screen) {
        super.setScreen(screen);
    }

    public void perviousClicked() {
        this.finish();
    }




}
