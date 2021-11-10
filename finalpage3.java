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

public class finalpage3 extends AppCompatActivity {
    TextView tv,tv1,tv2;
    private FirebaseUser user;
    private DatabaseReference reference;
    private String userid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalpage3);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        tv = findViewById(R.id.textView6);
        tv1 = findViewById(R.id.textView5);
        tv2 = findViewById(R.id.time);

        Intent intent1=getIntent();

        String seatId=intent1.getExtras().getString("seatId3");
        String date1=intent1.getExtras().getString("date3");
        String time1=intent1.getExtras().getString("time3");
        //String seatId2=intent1.getExtras().getString("seatId2");
        //String seatId3=intent1.getExtras().getString("seatId3");

        tv.setText(seatId);
        tv1.setText(date1);
        tv2.setText(time1);


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
                Toast.makeText(finalpage3.this,"Something went wrong",Toast.LENGTH_LONG).show();


            }
        });




    }
}