package com.appsnipp.equipmentmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.appsnipp.schooleducation.R;

public class SplashActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(homeIntent);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}