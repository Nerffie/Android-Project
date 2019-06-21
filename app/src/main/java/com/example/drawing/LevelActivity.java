package com.example.drawing;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
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
        Statistics.getGameStat();
        Statistics.setLevel(Asset.LEVEL);
        Asset.succes= 0;
        Asset.fail= 0;
        Asset.min_time = 0;
        Asset.avg_time= 0;
        Asset.scores_time = new ArrayList<>();

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
        for(int i=0; i<Asset.scores_time.size(); i++){
            Asset.avg_time += Asset.scores_time.get(i);
        }

        Asset.avg_time /= Asset.scores_time.size() !=0? Asset.scores_time.size():1;

        Log.i("tosend", "level " + Asset.LEVEL
                + " succes " + Asset.succes
                + " faild " + Asset.fail +
                " min time " + Asset.min_time +
                " min time " + Asset.avg_time);
        Statistics.setSuccessAttempts(Asset.succes);
        Statistics.setFailedAttempts(Asset.fail);
        Statistics.setMinTimeSucceed(Asset.min_time);
        Statistics.setAvgTimeSucceedSec(Asset.avg_time);

        LocationManager lm = (LocationManager) getSystemService(this.LOCATION_SERVICE);
        double longitude = 11.2555;
        double latitude =-2.55547;
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            //Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            //longitude = location.getLongitude();
            //latitude = location.getLatitude();
            //return;
        }

        Statistics.setGeoloc(longitude, latitude);
        Log.i("tosend", longitude+ " dsdf "+ latitude);
        Statistics.saveGame(this);
        super.onDestroy();
    }
}
