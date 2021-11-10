package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class finalpage2 extends AppCompatActivity {
    TextView tv,tv1,tv2;
    private FirebaseUser user;
    private DatabaseReference reference;
    private String userid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalpage2);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        tv = findViewById(R.id.seat2);
        tv1 = findViewById(R.id.date2);
        tv2 = findViewById(R.id.time2);

        Intent intent1=getIntent();

        String seatId2=intent1.getExtras().getString("seatId2");
        String date2=intent1.getExtras().getString("date2");
        String time2=intent1.getExtras().getString("time2");
        //String seatId2=intent1.getExtras().getString("seatId2");
        //String seatId3=intent1.getExtras().getString("seatId3");

        tv.setText(seatId2);
        tv1.setText(date2);
        tv2.setText(time2);


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
                Toast.makeText(finalpage2.this,"Something went wrong",Toast.LENGTH_LONG).show();


            }
        });




    }
}