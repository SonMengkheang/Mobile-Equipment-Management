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

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import static com.google.firebase.auth.FirebaseAuth.getInstance;

public class RegisterActivity extends AppCompatActivity {
    Button btnRegister;
    EditText txtEmail , txtName , txtPassword , txtConfirmPassword;
    ProgressBar progressBar;

    private FirebaseAuth mAuth;

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


        mAuth = getInstance();

        btnRegister.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String name = txtName.getText(). toString() . trim();
                String email = txtEmail.getText() .toString() .trim();
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
                       mAuth.createUserWithEmailAndPassword(email,password)
                               .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                                   @Override
                                   public void onComplete(@NonNull Task<AuthResult> task) {
                                       progressBar.setVisibility(View.GONE);
                                         if (task.isSuccessful()){
                                               startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                               Toast.makeText(RegisterActivity.this,"Authentication Completed",Toast.LENGTH_SHORT).show();
       
                                         }else{
                                               Toast.makeText(RegisterActivity.this,"Authentication Failed",Toast.LENGTH_SHORT).show();
                                         }
                                   }
                       });
                }


            }

        });


    }

//    public void gotoNext(View view) {
//        Intent dsp = new Intent(RegisterActivity.this,MainActivity.class);
//        startActivity(dsp);
//    }

    public void LogIn(View view) {
        Intent ds = new Intent(RegisterActivity.this,LoginActivity.class);
        startActivity(ds);

    }
}
