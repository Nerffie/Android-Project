package com.example.drawing;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.e_mobadara.audiomanaging.AudioSettingsActivity;
import com.example.ensias_auth_library.FoxyAuth;

public class ParameterActivity extends AppCompatActivity {

    EditText level1;
    EditText level2;
    EditText level3;
    Button saveValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parameter_activity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        level1 = findViewById(R.id.level1value);
        level2 = findViewById(R.id.level2value);
        level3 = findViewById(R.id.level3value);

        level1.setText(Integer.toString(Asset.fillPercentage[0]));
        level2.setText(Integer.toString(Asset.fillPercentage[1]));
        level3.setText(Integer.toString(Asset.fillPercentage[2]));
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

    public void saveValues(View view) {
     
        try{
            Asset.fillPercentage[0]=Integer.parseInt(level1.getText().toString());
        }catch (Exception e){
            Asset.fillPercentage[0]=200;
        }
        try{
            Asset.fillPercentage[1]=Integer.parseInt(level2.getText().toString());
        }catch (Exception e){
            Asset.fillPercentage[1]=400;
        }
        try{
            Asset.fillPercentage[2]=Integer.parseInt(level3.getText().toString());
        }catch (Exception e){
            Asset.fillPercentage[2]=150;
        }
        this.finish();
    }
}
