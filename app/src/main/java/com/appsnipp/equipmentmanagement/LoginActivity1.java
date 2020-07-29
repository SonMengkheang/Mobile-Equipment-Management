package com.appsnipp.equipmentmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import static com.google.firebase.auth.FirebaseAuth.getInstance;

public class LoginActivity1 extends AppCompatActivity {
    ImageView img;
    EditText txtEmail , txtPassword;
    Button btnLogin;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        img = findViewById(R.id.GoBackIcon);

        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        btnLogin = findViewById(R.id.btnLogin);

        mAuth = getInstance();



        btnLogin.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String email = txtEmail.getText() .toString() .trim();
                String password = txtPassword.getText() . toString() .trim() ;

                if(TextUtils.isEmpty(email)){
                    Toast.makeText(LoginActivity1.this,"Please Input Email",Toast.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(LoginActivity1.this,"Please Input Password",Toast.LENGTH_LONG).show();
                    return;
                }

                if (password.length()<6){
                    Toast.makeText(LoginActivity1.this,"Password is too short",Toast.LENGTH_SHORT).show();
                }


                mAuth.signInWithEmailAndPassword(email,password)
                        .addOnCompleteListener(LoginActivity1.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                    Toast.makeText(LoginActivity1.this,"Login Completed",Toast.LENGTH_SHORT).show();

                                }else{
                                    Toast.makeText(LoginActivity1.this,"Login Failed",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }

        });




    }

    public void goback(View view) {
        Intent ic = new Intent(LoginActivity1.this, RegisterActivity1.class);
        startActivity(ic);
    }

//    public void In(View view) {
//        Intent ic = new Intent(LoginActivity.this,MainActivity.class);
//        startActivity(ic);
//    }
}
