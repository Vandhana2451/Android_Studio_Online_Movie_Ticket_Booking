package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {
   private EditText t1;
   private Button reset;
   private ProgressBar pb;

   FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        mAuth = FirebaseAuth.getInstance();

        t1=(EditText) findViewById(R.id.t1);
        reset=(Button)findViewById(R.id.reset);
        pb=(ProgressBar)findViewById(R.id.progressBar2);

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetpwd();

            }

            private void resetpwd() {
                String email=t1.getText().toString().trim();

                if(email.isEmpty()){
                    t1.setError("Email is required");
                    t1.requestFocus();
                    return;
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    t1.setError("Provide valid email");
                    t1.requestFocus();
                    return;
                }
                pb.setVisibility(View.VISIBLE);
                mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(ForgotPassword.this,"Check your Email to reset your password",Toast.LENGTH_LONG).show();

                        }else{
                            Toast.makeText(ForgotPassword.this,"Try again, Something went wrong!",Toast.LENGTH_LONG).show();
                        }

                    }
                });
            }
        });

    }

}