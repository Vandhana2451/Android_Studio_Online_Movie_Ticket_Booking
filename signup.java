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
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class signup extends AppCompatActivity implements View.OnClickListener {

    private EditText e1, e2, e3, e4;
    private Button b;
    private ProgressBar pb;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mAuth = FirebaseAuth.getInstance();
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        b = (Button) findViewById(R.id.signup);
        b.setOnClickListener(this);
        e1 = (EditText) findViewById(R.id.fullname);
        e2 = (EditText) findViewById(R.id.username);
        e3 = (EditText) findViewById(R.id.email);
        e4 = (EditText) findViewById(R.id.password);


        pb = (ProgressBar) findViewById(R.id.progressBar);



    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.signup:
                button();
                break;
        }

    }

    private void button() {
        String name = e1.getText().toString().trim();
        String uname = e2.getText().toString().trim();
        String email = e3.getText().toString().trim();
        String pwd = e4.getText().toString().trim();

        if (name.isEmpty()) {
            e1.setError("Fullname is req");
            e1.requestFocus();
            return;
        }
        if (uname.isEmpty()) {
            e2.setError("Username is req");
            e2.requestFocus();
            return;
        }
        if (email.isEmpty()) {
            e3.setError("@ is req");
            e3.requestFocus();
            return;
        }
        if (pwd.length() < 6) {
            e4.setError("Min password length should be 6 characters!");
            e4.requestFocus();
            return;
        }

        if(Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            e3.setError("Provide valid email");
        }
        if (pwd.isEmpty()) {
            e4.setError(" all fields is required");
            e4.requestFocus();
            return;
        }

        pb.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email, pwd)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {


                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            User user = new User(name, uname, email, pwd);

                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(signup.this, "user has been registered", Toast.LENGTH_LONG).show();
                                        pb.setVisibility(View.GONE);
                                    } else {
                                        Toast.makeText(signup.this, "Failed", Toast.LENGTH_LONG).show();
                                        pb.setVisibility(View.GONE);
                                    }
                                }
                            });
                        } else {
                            Toast.makeText(signup.this, "Failed", Toast.LENGTH_LONG).show();
                            pb.setVisibility(View.GONE);

                        }
                    }
                });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(signup.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
