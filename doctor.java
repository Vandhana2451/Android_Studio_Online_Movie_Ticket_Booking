package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class doctor extends AppCompatActivity {
    VideoView v3;
    Button b;

    private FirebaseUser user;
    private DatabaseReference reference;
    private String userid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        v3 = (VideoView)findViewById(R.id.video3);
        String videoPath="android.resource://" +getPackageName() + "//" + R.raw.video3;
        Uri uri=Uri.parse(videoPath);
        v3.setVideoURI(uri);

        MediaController mediaController=new MediaController(this);
        v3.setMediaController(mediaController);
        mediaController.setAnchorView(v3);

        b=(Button)findViewById(R.id.bt3);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view){
                Intent intent = new Intent(doctor.this,
                        date_time_3.class);
                startActivity(intent);
            }
        });

        user= FirebaseAuth.getInstance().getCurrentUser();
        reference= FirebaseDatabase.getInstance().getReference("Users");
        userid=user.getUid();

        final TextView user_name=(TextView)findViewById(R.id.username);
        reference.child(userid).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userprofile=snapshot.getValue(User.class);

                if(userprofile!=null){
                    String username1=userprofile.uname;

                    user_name.setText(username1);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(doctor.this,"Something went wrong",Toast.LENGTH_LONG).show();


            }
        });


    }
}