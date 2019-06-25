package com.example.drawing.activity;
import android.media.MediaPlayer;

import com.e_mobadara.audiomanaging.moblibAudioFileManager;
import com.example.drawing.screen.MyScreen;
import com.example.drawing.asset.Asset;
import com.example.emobadaragaminglib.Base.Screen;
import com.example.emobadaragaminglib.Implementation.AndroidGame;

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
