package com.example.project;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView signUp,forgotpwd;
    private EditText e1,e2;
    private Button button;
    private ProgressBar pb;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        signUp=(TextView)findViewById(R.id.signup);
        signUp.setOnClickListener(this);
        button=(Button)findViewById(R.id.login);
        button.setOnClickListener(this);

        e1=(EditText)findViewById(R.id.email);
        e2=(EditText)findViewById(R.id.pwd);

        pb=(ProgressBar)findViewById(R.id.progressBar);
        forgotpwd=(TextView) findViewById(R.id.fp);
        forgotpwd.setOnClickListener(this);

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);







    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.signup:
                startActivity(new Intent(this,signup.class));
                break;


            case R.id.login:
                userLogin();
                break;

            case R.id.fp:
                startActivity(new Intent(this,ForgotPassword.class));
                break;
        }
    }

    private void userLogin() {
        String email=e1.getText().toString().trim();
        String pwd=e2.getText().toString().trim();

        if(email.isEmpty()){
            e1.setError("Email is required");
            e1.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            e1.setError("Provide valid email");
            e1.requestFocus();
            return;
        }
       if(pwd.isEmpty()){
           e2.setError("Password is required");
           e2.requestFocus();
           return;

        }
        if (pwd.length() < 6) {
            e2.setError("Min password length should be 6 characters!");
            e2.requestFocus();
            return;
        }
        pb.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(email,pwd)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();

                            if(user.isEmailVerified()){
                                startActivity(new Intent(MainActivity.this,ProfileActivity.class));

                            }else{
                                user.sendEmailVerification();
                                Toast.makeText(MainActivity.this,"Check Your Email to Verify your Account",Toast.LENGTH_LONG).show();

                            }


                        }else{
                            Toast.makeText(MainActivity.this,"Failed to Login Please Check your credential",Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}