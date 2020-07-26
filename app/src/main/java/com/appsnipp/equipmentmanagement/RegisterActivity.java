package com.appsnipp.equipmentmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btn = findViewById(R.id.joinus);
    }

    public void gotoNext(View view) {
        Intent dsp = new Intent(RegisterActivity.this,MainActivity.class);
        startActivity(dsp);
    }

    public void LogIn(View view) {
        Intent ds = new Intent(RegisterActivity.this,LoginActivity.class);
        startActivity(ds);

    }
}
