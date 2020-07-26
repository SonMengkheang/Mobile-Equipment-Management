package com.appsnipp.equipmentmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        img = findViewById(R.id.GoBackIcon);
    }

    public void goback(View view) {
        Intent ic = new Intent(LoginActivity.this,RegisterActivity.class);
        startActivity(ic);
    }

    public void In(View view) {
        Intent ic = new Intent(LoginActivity.this,MainActivity.class);
        startActivity(ic);
    }
}
