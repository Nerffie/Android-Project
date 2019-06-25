package com.example.drawing.activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.e_mobadara.audiomanaging.AudioSettingsActivity;
import com.example.drawing.R;
import com.example.drawing.asset.Asset;

//import com.e_mobadara.audiomanaging.AudioSettingsActivity;

import java.util.Locale;



public class ChoixLangActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);
        setContentView(R.layout.activity_lang);
        Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab_setAudio);
    }

    public void LangActivityonClick(View v) {
        Intent intent = null;
        Log.i("info", "lang \n =====================================" +
                "un choix de langue a été effectué" +
                "\n ========================================");
        switch (v.getId()) {
            case R.id.francais_button:
                setLocale("fr");
                Asset.LANG = "fr";
                intent = new Intent(this, LevelActivity.class);
                break;
            case R.id.english_button:
                setLocale("en");
                Asset.LANG = "en";
                intent = new Intent(this, LevelActivity.class);
                break;

            case R.id.arabic_button:
                setLocale("ar");
                Asset.LANG = "ar";
                intent = new Intent(this, LevelActivity.class);
                break;
        }
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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
