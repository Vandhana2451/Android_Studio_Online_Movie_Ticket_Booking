package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity {
    ViewFlipper v_flipper;
    ImageButton b1, b2, b3;
    int buttonselection;

    private FirebaseUser user;
    private DatabaseReference reference;
    private String userid;
    public static String movieName=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        b1 = (ImageButton) findViewById(R.id.annaathe);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(b1.getId()==v.getId()){
                    buttonselection=1;
                    movieName = "Annathae";
                    Intent intent = new Intent(ProfileActivity.this, annaathe.class);
                    startActivity(intent);

                }




            }



        });

        b2 = (ImageButton) findViewById(R.id.maanaadu);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(b2.getId()==v.getId()){
                    buttonselection=2;
                    movieName = "Maanaadu";
                    Intent intent = new Intent(ProfileActivity.this, maanaadu.class);
                    startActivity(intent);

                }
            }

        });

        b3 = (ImageButton) findViewById(R.id.doctor);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(b3.getId()==v.getId()){
                    buttonselection=3;
                    movieName = "Doctor";
                    Intent intent = new Intent(ProfileActivity.this, doctor.class);
                    startActivity(intent);

                }
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
                Toast.makeText(ProfileActivity.this,"Something went wrong",Toast.LENGTH_LONG).show();


            }
        });







        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        int images[] = {R.drawable.doctor, R.drawable.annathe, R.drawable.maanadu};

        v_flipper = findViewById(R.id.v_flipper);

        for (int image : images) {
            flipperImage(image);
        }

    }
        public void flipperImage ( int image){
            ImageView imageview = new ImageView(this);
            imageview.setBackgroundResource(image);

            v_flipper.addView(imageview);
            v_flipper.setFlipInterval(4000);
            v_flipper.setAutoStart(true);

            v_flipper.setInAnimation(this, android.R.anim.slide_in_left);
            v_flipper.setOutAnimation(this, android.R.anim.slide_out_right);
        }





    }
