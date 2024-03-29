package com.example.drawing.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.support.design.widget.FloatingActionButton;

import com.e_mobadara.audiomanaging.AudioSettingsActivity;
import com.example.drawing.music.MusicFond;
import com.example.drawing.R;
import com.example.drawing.music.ServiceSon;
import com.example.ensias_auth_library.FoxyAuth;

public class MainActivity extends AppCompatActivity {

    public  static  Boolean isMusicPlay = false;
    public static Intent music = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_test);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = findViewById(R.id.fab);


        FoxyAuth.emerge(this,MainActivity.class);
        music = MusicFond.getMusic (MainActivity.this);
        startService(music);
        isMusicPlay = true;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleMusic(view);
            }
        });



    }
    @Override
    public void onResume(){
        super.onResume();
        if (isMusicPlay == true) {
            startService(music);

        } else {
            stopService(music);
        }

    }
    public void handleMusic(View view) {
        if (isMusicPlay == true) {
            stopService(music);
            isMusicPlay = false;
        } else {
            startService(music);
            isMusicPlay = true;
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        stopService(music);
        isMusicPlay = false;
        this.finish();
    }
    public void perviousClicked( View v) {
        stopService(music);
        isMusicPlay = false;
        this.finish();
    }

    public void AudioSettings(View view) {
        Intent i = new Intent(this, AudioSettingsActivity.class);
        startActivity(i);
    }

    public void Parameter(View view){
        Intent i = new Intent(this, ParameterActivity.class);
        startActivity(i);
    }

    public void MainActivityOnClick(View v){
        Intent intent = null;
        switch (v.getId()) {
            case R.id.start_btn:
                intent = new Intent(this, ChoixLangActivity.class);
                break;
        }
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //if (id == R.id.action_settings) {
          //  return true;
        //}

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopService(new Intent(MainActivity.this, ServiceSon.class));
    }

}
