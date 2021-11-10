package com.example.project;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class date_time extends AppCompatActivity {
    String[] date = { "03/11/2021(Wed)", "04/11/2021(Thu)", "05/11/2021(Fri)"};
    Button seat;
    RadioGroup rg,rg1;
    RadioButton rb1,rb2,rb3,rb4,rb5,rb6,rb7,rb8,rb9;
    public static String timeSlot1 = null;
    public static String dateSlot1 = null;
    public static int seatSlot1=0;
    private FirebaseUser user;
    private DatabaseReference reference;
    private String userid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        seat = (Button) findViewById(R.id.seat);
        rb1 = (RadioButton) findViewById(R.id.radioButton);
        rb2 = (RadioButton) findViewById(R.id.radioButton2);
        rb3 = (RadioButton) findViewById(R.id.radioButton3);

        rg = (RadioGroup) findViewById(R.id.radioGroup);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == rb1.getId()) {
                    timeSlot1 = "10:00 AM";
                } else if (checkedId == rb2.getId()) {
                    timeSlot1 = "3:00 PM";
                } else if (checkedId == rb3.getId()) {
                    timeSlot1 = "7:00 PM";
                }

            }
        });

        rb4 = (RadioButton) findViewById(R.id.radioButton10);
        rb5 = (RadioButton) findViewById(R.id.radioButton4);
        rb6 = (RadioButton) findViewById(R.id.radioButton5);
        rb7 = (RadioButton) findViewById(R.id.radioButton6);
        rb8 = (RadioButton) findViewById(R.id.radioButton7);
        rb9 = (RadioButton) findViewById(R.id.radioButton8);


        rg1 = (RadioGroup) findViewById(R.id.radioGroup1);

        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == rb4.getId()) {
                    seatSlot1 = Integer.parseInt("1");
                } else if (i == rb5.getId()) {
                    seatSlot1 = Integer.parseInt("2");
                } else if (i == rb6.getId()) {
                    seatSlot1 = Integer.parseInt("3");
                } else if (i == rb7.getId()) {
                    seatSlot1 = Integer.parseInt("4");
                } else if (i == rb8.getId()) {
                    seatSlot1 = Integer.parseInt("5");
                } else if (i == rb9.getId()) {
                    seatSlot1 = Integer.parseInt("6");

                }
            }
        });





        //Getting the instance of Spinner and applying OnItemSelectedListener on it
        Spinner spin = (Spinner) findViewById(R.id.spinner);



        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, date);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);

        seat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dateSlot1 = spin.getSelectedItem().toString();

                validation();



            }

            private void validation() {

                int isSelected=rg.getCheckedRadioButtonId();
                int isSelected1=rg1.getCheckedRadioButtonId();
                if(isSelected==-1){
                    Toast.makeText(date_time.this,"you have to select the time slot",Toast.LENGTH_LONG).show();
                    return;
                }
                if(isSelected1==-1){
                    Toast.makeText(date_time.this,"you have to select the no.of seat",Toast.LENGTH_LONG).show();
                    return;
                }
                Intent intent = new Intent(date_time.this,
                        seats.class);
                //Toast.makeText(getApplicationContext(),dateSlot1,Toast.LENGTH_SHORT).show();

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
                Toast.makeText(date_time.this,"Something went wrong",Toast.LENGTH_LONG).show();


            }
        });




    }
}