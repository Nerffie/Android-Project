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

    public void initAssets(){
        //Images
        //Asset.avatar = getGraphics().newImage(R.drawable.snake,Graphics.ImageFormat.ARGB8888,getResources());
        //Asset.cercle = getGraphics().newImage(R.drawable.cercle,Graphics.ImageFormat.ARGB8888,getResources());
        //Asset.carre = getGraphics().newImage(R.drawable.carre,Graphics.ImageFormat.ARGB8888,getResources());

        //Asset.red_dot = getGraphics().newImage(R.drawable.red_dot,Graphics.ImageFormat.ARGB8888,getResources());
        //Asset.blue_dot = getGraphics().newImage(R.drawable.blue_dot,Graphics.ImageFormat.ARGB8888,getResources());
        //Asset.green_dot = getGraphics().newImage(R.drawable.green_dot,Graphics.ImageFormat.ARGB8888,getResources());

        //Asset.red_sprite = getGraphics().newImage(R.drawable.rouge,Graphics.ImageFormat.ARGB8888,getResources());
        //Asset.blue_clair_sprite = getGraphics().newImage(R.drawable.bleu_clair,Graphics.ImageFormat.ARGB8888,getResources());
        //Asset.green_clair_sprite = getGraphics().newImage(R.drawable.vert_clair,Graphics.ImageFormat.ARGB8888,getResources());
        //Asset.yellow_sprite = getGraphics().newImage(R.drawable.jaune,Graphics.ImageFormat.ARGB8888,getResources());
        //Asset.rose_sprite = getGraphics().newImage(R.drawable.rose,Graphics.ImageFormat.ARGB8888,getResources());
        //Asset.blue_fonce_sprite = getGraphics().newImage(R.drawable.bleu_fonce,Graphics.ImageFormat.ARGB8888,getResources());
        //Asset.bg1 = getGraphics().newImage(R.drawable.bg,Graphics.ImageFormat.ARGB8888,getResources());
        //Asset.bg2 = getGraphics().newImage(R.drawable.bg2,Graphics.ImageFormat.ARGB8888,getResources());

        Asset.reset = getGraphics().newImage(R.drawable.reset,Graphics.ImageFormat.ARGB8888,getResources());
        //MusicInstr.floor_tom_image = getGraphics().newImage(R.drawable.floor_tom,Graphics.ImageFormat.ARGB8888,getResources());
        //MusicInstr.hihat_image = getGraphics().newImage(R.drawable.hihat,Graphics.ImageFormat.ARGB8888,getResources());
        //MusicInstr.snare_image = getGraphics().newImage(R.drawable.snare,Graphics.ImageFormat.ARGB8888,getResources());
        Log.i(TAG, "initAssets: Loaded the Images");
        //Audio
        //Decor.forbidden_zone = (AndroidSound)getAudio().createSound(R.raw.error);
        //MusicInstr.bass_audio = (AndroidSound) getAudio().createSound(R.raw.kick);
        //MusicInstr.floor_tom_audio = (AndroidSound) getAudio().createSound(R.raw.floor_tom);
        //MusicInstr.hihat_audio = (AndroidSound) getAudio().createSound(R.raw.hi_hat_closed);
        //MusicInstr.snare_audio = (AndroidSound) getAudio().createSound(R.raw.snare);
        Log.i(TAG, "initAssets: Loaded the Audio");
        //Decor




    }
}
