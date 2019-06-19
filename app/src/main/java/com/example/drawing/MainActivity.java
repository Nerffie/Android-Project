package com.example.drawing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    private static final String TAG ="LoadingActivity";
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            Intent mIntent =  new Intent(MainActivity.this,GameActivity.class);
            Log.i(TAG, "run: Goign to start the GameActivity");
            MainActivity.this.startActivity(mIntent);
            //For The animation
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Have a full Screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Setting the Layout
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate: Loading the background image");

        //Loading the Gif
        ImageView mImageView = findViewById(R.id.drawing_start);
        mImageView.setImageResource(R.drawable.coloriage_titre);


        Log.i(TAG, "onCreate: Waiting for the 2sec before starting the activity");
        //Wait for the Loading of the Assets and Starting the Game
        handler.postDelayed(runnable,2000);
    }

}
