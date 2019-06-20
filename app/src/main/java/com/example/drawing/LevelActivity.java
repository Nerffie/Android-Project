package com.example.drawing;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import java.util.ArrayList;
import java.util.Locale;

import com.e_mobadara.audiomanaging.AudioSettingsActivity;
import com.example.drawing.MainActivity;

public class LevelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
    }

    public void LevelActivityClick(View v) {
        Intent intent = null;
        Log.i("info", "lang \n =====================================" +
                "\nun choix de Niveau a été effectué" +
                "\n ========================================");
        intent = new Intent(this,GameActivity.class);
        switch (v.getId()) {
            case R.id.level1_button:
                Asset.LEVEL= 1;

                break;
            case R.id.level2_button:
                Asset.LEVEL= 2;

                break;

            case R.id.level3_button:
                Asset.LEVEL= 3;
                break;
        }

        // game stat data
        //Statistics.getGameStat();
        //Statistics.setLevel(Asset.LEVEL);
        //Asset.successAttempts= 0;
        //Asset.failedAttempts= 0;
        //Asset.failedAttempts= 0;
        //Asset.min_time = 0;
        //Asset.avg_time= 0;
        //Asset.scores_time = new ArrayList<>();

        startActivity(intent);
    }

    private void setLocale(String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());


    }

    public void handleMusic(View view) {
        if (MainActivity.isMusicPlay == true) {
            stopService(MainActivity.music);
            MainActivity.isMusicPlay = false;
        } else {
            startService(MainActivity.music);
            MainActivity.isMusicPlay = true;
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
    public void perviousClicked( View v) {
        this.finish();
    }

    public void AudioSettings(View view) {
        Intent i = new Intent(this, AudioSettingsActivity.class);
        startActivity(i);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
