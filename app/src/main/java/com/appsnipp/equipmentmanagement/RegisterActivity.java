package com.appsnipp.equipmentmanagement;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {
    Button btnRegister;
    EditText txtEmail , txtName , txtPassword , txtConfirmPassword;
    ProgressBar progressBar;


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        txtName = (EditText) findViewById(R.id.txtName);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        txtConfirmPassword = (EditText) findViewById(R.id.txtConfirmPassword);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        btnRegister = (Button) findViewById(R.id.joinus);



        final String url = "http://localhost:3000/users";

        btnRegister.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                final String gender="";
                final    String phone="";
                final String address="";
                final String profile="";

                final String name = txtName.getText(). toString() . trim();
                final String email = txtEmail.getText() .toString() .trim();
                String password = txtPassword.getText() . toString() .trim() ;
                String password2 = txtConfirmPassword.getText() . toString() .trim() ;

                if(TextUtils.isEmpty(name)){
                    Toast.makeText(RegisterActivity.this,"Please Input Username",Toast.LENGTH_LONG).show();
                    return;
                }
                if(TextUtils.isEmpty(email)){
                    Toast.makeText(RegisterActivity.this,"Please Input Email",Toast.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(RegisterActivity.this,"Please Input Password",Toast.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(password2)) {
                    Toast.makeText(RegisterActivity.this,"Please Input Confirm Password",Toast.LENGTH_LONG).show();
                    return;
                }

                if(password.length()<6){
                    Toast.makeText(RegisterActivity.this,"Password is to short",Toast.LENGTH_SHORT).show();
                }


                progressBar.setVisibility(View.VISIBLE);

                if (password.equals(password2)) {



                }


            }

        });


    }


    public void LogIn(View view) {
        Intent ds = new Intent(RegisterActivity.this, LoginActivity1.class);
        startActivity(ds);

    }
}
