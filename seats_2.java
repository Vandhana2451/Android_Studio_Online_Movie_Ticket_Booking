package com.example.project;

import static com.example.project.ProfileActivity.movieName;
import static com.example.project.date_time.dateSlot1;
import static com.example.project.date_time.seatSlot1;
import static com.example.project.date_time.timeSlot1;
import static com.example.project.date_time_2.dateSlot2;
import static com.example.project.date_time_2.seatSlot2;
import static com.example.project.date_time_2.timeSlot2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
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

public class seats_2 extends AppCompatActivity {
    private FirebaseUser user;
    private DatabaseReference reference;
    private String userid;
    public static String seatid2=null;
    public static String total2=null;

    Button b;
    private CheckBox chk1, chk2, chk3,chk4,chk5,chk6,chk7,chk8,chk9,chk10,
            chk11,chk12, chk13,chk14,chk15,chk16,chk17,chk18,chk19,chk20,
            chk21,chk22, chk23,chk24,chk25,chk26,chk27,chk28,chk29,chk30,
            chk31, chk32, chk33,chk34,chk35,chk36,chk37,chk38,chk39,chk40,
            chk41, chk42, chk43,chk44,chk45,chk46,chk47,chk48,chk49,chk50,
            chk51, chk52, chk53,chk54,chk55,chk56,chk57,chk58,chk59,chk60,
            chk61, chk62, chk63,chk64,chk65,chk66,chk67,chk68,chk69,chk70,
            chk71,chk72;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seats2);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Toast.makeText(seats_2.this, movieName + "\n" + dateSlot2 + "\n" + timeSlot2 + "\n" + seatSlot2, Toast.LENGTH_LONG).show();
        chk1 = (CheckBox) findViewById(R.id.A1);
        chk2 = (CheckBox) findViewById(R.id.A2);
        chk3 = (CheckBox) findViewById(R.id.A3);
        chk4 = (CheckBox) findViewById(R.id.A4);
        chk5 = (CheckBox) findViewById(R.id.A5);
        chk6 = (CheckBox) findViewById(R.id.A6);
        chk7 = (CheckBox) findViewById(R.id.A7);
        chk8 = (CheckBox) findViewById(R.id.A8);
        chk9 = (CheckBox) findViewById(R.id.A9);
        chk10 = (CheckBox) findViewById(R.id.A10);


        chk11 = (CheckBox) findViewById(R.id.B1);
        chk12 = (CheckBox) findViewById(R.id.B2);
        chk13 = (CheckBox) findViewById(R.id.B3);
        chk14 = (CheckBox) findViewById(R.id.B4);
        chk15 = (CheckBox) findViewById(R.id.B5);
        chk16 = (CheckBox) findViewById(R.id.B6);
        chk17 = (CheckBox) findViewById(R.id.B7);
        chk18 = (CheckBox) findViewById(R.id.B8);
        chk19 = (CheckBox) findViewById(R.id.B9);
        chk20 = (CheckBox) findViewById(R.id.B10);


        chk21 = (CheckBox) findViewById(R.id.C1);
        chk22 = (CheckBox) findViewById(R.id.C2);
        chk23 = (CheckBox) findViewById(R.id.C3);
        chk24 = (CheckBox) findViewById(R.id.C4);
        chk25 = (CheckBox) findViewById(R.id.C5);
        chk26 = (CheckBox) findViewById(R.id.C6);
        chk27 = (CheckBox) findViewById(R.id.C7);
        chk28 = (CheckBox) findViewById(R.id.C8);

        chk30 = (CheckBox) findViewById(R.id.D1);
        chk31 = (CheckBox) findViewById(R.id.D2);
        chk32 = (CheckBox) findViewById(R.id.D3);
        chk33 = (CheckBox) findViewById(R.id.D4);
        chk34 = (CheckBox) findViewById(R.id.D5);
        chk35 = (CheckBox) findViewById(R.id.D6);
        chk36 = (CheckBox) findViewById(R.id.D7);
        chk37 = (CheckBox) findViewById(R.id.D8);


        chk38 = (CheckBox) findViewById(R.id.E1);
        chk39 = (CheckBox) findViewById(R.id.E2);
        chk40 = (CheckBox) findViewById(R.id.E3);
        chk41 = (CheckBox) findViewById(R.id.E4);
        chk42 = (CheckBox) findViewById(R.id.E5);
        chk43 = (CheckBox) findViewById(R.id.E6);
        chk44 = (CheckBox) findViewById(R.id.E7);
        chk45 = (CheckBox) findViewById(R.id.E8);
        chk46 = (CheckBox) findViewById(R.id.E9);
        chk47 = (CheckBox) findViewById(R.id.E10);


        chk48 = (CheckBox) findViewById(R.id.F1);
        chk49 = (CheckBox) findViewById(R.id.F2);
        chk50 = (CheckBox) findViewById(R.id.F3);
        chk51 = (CheckBox) findViewById(R.id.F4);
        chk52 = (CheckBox) findViewById(R.id.F5);
        chk53 = (CheckBox) findViewById(R.id.F6);
        chk54 = (CheckBox) findViewById(R.id.F7);
        chk55 = (CheckBox) findViewById(R.id.F8);
        chk56 = (CheckBox) findViewById(R.id.F9);
        chk57 = (CheckBox) findViewById(R.id.F10);


        chk58 = (CheckBox) findViewById(R.id.G1);
        chk59 = (CheckBox) findViewById(R.id.G2);
        chk60 = (CheckBox) findViewById(R.id.G3);
        chk61 = (CheckBox) findViewById(R.id.G4);
        chk62 = (CheckBox) findViewById(R.id.G5);
        chk63 = (CheckBox) findViewById(R.id.G6);
        chk64 = (CheckBox) findViewById(R.id.G7);
        chk65 = (CheckBox) findViewById(R.id.G8);


        chk66 = (CheckBox) findViewById(R.id.H1);
        chk67 = (CheckBox) findViewById(R.id.H2);
        chk68 = (CheckBox) findViewById(R.id.H3);
        chk69 = (CheckBox) findViewById(R.id.H4);
        chk70 = (CheckBox) findViewById(R.id.H5);
        chk71 = (CheckBox) findViewById(R.id.H6);
        chk72 = (CheckBox) findViewById(R.id.H7);
        chk29 = (CheckBox) findViewById(R.id.H8);


        b = (Button) findViewById(R.id.selectseat);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validation();


            }
        });

        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        userid = user.getUid();

        final TextView user_name = (TextView) findViewById(R.id.username);
        reference.child(userid).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userprofile = snapshot.getValue(User.class);

                if (userprofile != null) {
                    String username1 = userprofile.uname;

                    user_name.setText(username1);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(seats_2.this, "Something went wrong", Toast.LENGTH_LONG).show();


            }
        });

    }

        private void validation() {

            if(!chk1.isChecked() && !chk2.isChecked() && !chk3.isChecked() && !chk4.isChecked() && !chk5.isChecked() && !chk6.isChecked()
                    && !chk7.isChecked() && !chk8.isChecked() && !chk9.isChecked() && !chk10.isChecked() && !chk11.isChecked() && !chk12.isChecked() && !chk13.isChecked()
                    && !chk14.isChecked() && !chk15.isChecked() && !chk16.isChecked()
                    && !chk17.isChecked() && !chk18.isChecked() && !chk19.isChecked() && !chk20.isChecked() && !chk21.isChecked() && !chk22.isChecked()
                    && !chk23.isChecked() && !chk24.isChecked() && !chk25.isChecked() && !chk26.isChecked()
                    && !chk27.isChecked() && !chk28.isChecked() && !chk29.isChecked() && !chk30.isChecked() && !chk31.isChecked() && !chk32.isChecked()
                    && !chk33.isChecked() && !chk34.isChecked() && !chk35.isChecked() && !chk36.isChecked()
                    && !chk37.isChecked() && !chk38.isChecked() && !chk39.isChecked() && !chk40.isChecked() && !chk41.isChecked() && !chk42.isChecked()
                    && !chk43.isChecked() && !chk44.isChecked() && !chk45.isChecked() && !chk46.isChecked()
                    && !chk47.isChecked() && !chk48.isChecked() && !chk49.isChecked() && !chk50.isChecked() && !chk51.isChecked() && !chk52.isChecked()
                    && !chk53.isChecked() && !chk54.isChecked() && !chk55.isChecked() && !chk56.isChecked()
                    && !chk57.isChecked() && !chk58.isChecked() && !chk59.isChecked() && !chk60.isChecked() && !chk61.isChecked() && !chk62.isChecked()
                    && !chk63.isChecked() && !chk64.isChecked() && !chk65.isChecked() && !chk66.isChecked()
                    && !chk67.isChecked() && !chk68.isChecked() && !chk69.isChecked() && !chk70.isChecked() && !chk71.isChecked() && !chk72.isChecked())
            {
                Toast.makeText(seats_2.this,"you have to select the seats",Toast.LENGTH_LONG).show();
                return;

            }
            StringBuilder result=new StringBuilder();
            StringBuilder total1=new StringBuilder();
            result.append("Seats: ");
            //total1.append("Total Amount:");
            int totalamount=0;
            int checked=0;
            if(chk1.isChecked()==true)
            {
                checked+=1;
                result.append("A1");
                totalamount+=100;

            }

            if(chk2.isChecked()==true)
            {
                checked+=1;
                result.append("A2");
                totalamount+=100;

            }

            if(chk3.isChecked()==true)
            {
                checked+=1;
                result.append("A3");
                totalamount+=100;
            }

            if(chk4.isChecked()==true)
            {
                checked+=1;
                result.append("A4");
                totalamount+=100;

            }

            if(chk5.isChecked()==true)
            {
                checked+=1;
                result.append("A5");
                totalamount+=100;
            }

            if(chk6.isChecked()==true)
            {
                checked+=1;
                result.append("A6");
                totalamount+=100;
            }
            if(chk7.isChecked()==true)
            {
                checked+=1;
                result.append("A7");
                totalamount+=100;

            }

            if(chk8.isChecked()==true)
            {
                checked+=1;
                result.append("A8");
                totalamount+=100;
            }

            if(chk9.isChecked()==true)
            {
                checked+=1;
                result.append("A9");
                totalamount+=100;
            }

            if(chk10.isChecked()==true)
            {
                checked+=1;
                result.append("A10");
                totalamount+=100;

            }

            if(chk11.isChecked()==true)
            {
                checked+=1;
                result.append("B1");
                totalamount+=100;
            }

            if(chk12.isChecked()==true)
            {
                checked+=1;
                result.append("B2");
                totalamount+=100;
            }

            if(chk13.isChecked()==true)
            {
                checked+=1;
                result.append("B3");
                totalamount+=100;

            }

            if(chk14.isChecked()==true)
            {
                checked+=1;
                result.append("B4");
                totalamount+=100;
            }

            if(chk15.isChecked()==true)
            {
                checked+=1;
                result.append("B5");
                totalamount+=100;
            }

            if(chk16.isChecked()==true)
            {
                checked+=1;
                result.append("B6");
                totalamount+=100;

            }

            if(chk17.isChecked()==true)
            {
                checked+=1;
                result.append("B7");
                totalamount+=100;
            }

            if(chk18.isChecked()==true)
            {
                checked+=1;
                result.append("B8");
                totalamount+=100;
            }

            if(chk19.isChecked()==true)
            {
                checked+=1;
                result.append("B9");
                totalamount+=100;

            }

            if(chk20.isChecked()==true)
            {
                checked+=1;
                result.append("B10");
                totalamount+=100;
            }

            if(chk21.isChecked()==true)
            {
                checked+=1;
                result.append("C1");
                totalamount+=100;
            }

            if(chk22.isChecked()==true)
            {
                checked+=1;
                result.append("C2");
                totalamount+=100;

            }

            if(chk23.isChecked()==true)
            {
                checked+=1;
                result.append("C3");
                totalamount+=100;
            }

            if(chk24.isChecked()==true)
            {
                checked+=1;
                result.append("C4");
                totalamount+=100;
            }

            if(chk25.isChecked()==true)
            {
                checked+=1;
                result.append("C5");
                totalamount+=100;

            }

            if(chk26.isChecked()==true)
            {
                checked+=1;
                result.append("C6");
                totalamount+=100;
            }

            if(chk27.isChecked()==true)
            {
                checked+=1;
                result.append("C7");
                totalamount+=100;
            }

            if(chk28.isChecked()==true)
            {
                checked+=1;
                result.append("C8");
                totalamount+=100;

            }

            if(chk29.isChecked()==true)
            {
                checked+=1;
                result.append("H8");
                totalamount+=60;
            }

            if(chk30.isChecked()==true)
            {
                checked+=1;
                result.append("D1");
                totalamount+=100;
            }

            if(chk31.isChecked()==true)
            {
                checked+=1;
                result.append("D2");
                totalamount+=100;

            }

            if(chk32.isChecked()==true)
            {
                checked+=1;
                result.append("D3");
                totalamount+=100;
            }

            if(chk33.isChecked()==true)
            {
                checked+=1;
                result.append("D4");
                totalamount+=100;
            }

            if(chk34.isChecked()==true)
            {
                checked+=1;
                result.append("D5");
                totalamount+=100;

            }

            if(chk35.isChecked()==true)
            {
                checked+=1;
                result.append("D6");
                totalamount+=100;
            }

            if(chk36.isChecked()==true)
            {
                checked+=1;
                result.append("D7");
                totalamount+=100;

            }
            if(chk37.isChecked()==true)
            {
                checked+=1;
                result.append("D8");
                totalamount+=100;

            }

            if(chk38.isChecked()==true)
            {
                checked+=1;
                result.append("E1");
                totalamount+=100;
            }

            if(chk39.isChecked()==true)
            {
                checked+=1;
                result.append("E2");
                totalamount+=100;
            }

            if(chk40.isChecked()==true)
            {
                checked+=1;
                result.append("E3");
                totalamount+=100;

            }

            if(chk41.isChecked()==true)
            {
                checked+=1;
                result.append("E4");
                totalamount+=100;
            }

            if(chk42.isChecked()==true)
            {
                checked+=1;
                result.append("E5");
                totalamount+=100;
            }

            if(chk43.isChecked()==true)
            {
                checked+=1;
                result.append("E6");
                totalamount+=100;

            }

            if(chk44.isChecked()==true)
            {
                checked+=1;
                result.append("E7");
                totalamount+=100;
            }

            if(chk45.isChecked()==true)
            {
                checked+=1;
                result.append("E8");
                totalamount+=100;
            }

            if(chk46.isChecked()==true)
            {
                checked+=1;
                result.append("E9");
                totalamount+=100;


            }

            if(chk47.isChecked()==true)
            {
                checked+=1;
                result.append("E10");
                totalamount+=100;
            }

            if(chk48.isChecked()==true)
            {
                checked+=1;
                result.append("F1");
                totalamount+=100;
            }

            if(chk49.isChecked()==true)
            {
                checked+=1;
                result.append("F2");
                totalamount+=100;

            }

            if(chk50.isChecked()==true)
            {
                checked+=1;
                result.append("F3");
                totalamount+=100;
            }

            if(chk51.isChecked()==true)
            {
                checked+=1;
                result.append("F4");
                totalamount+=100;
            }

            if(chk52.isChecked()==true)
            {
                checked+=1;
                result.append("F5");
                totalamount+=100;

            }

            if(chk53.isChecked()==true)
            {
                checked+=1;
                result.append("F6");
            }

            if(chk54.isChecked()==true)
            {
                checked+=1;
                result.append("F7");
            }

            if(chk55.isChecked()==true)
            {
                checked+=1;
                result.append("F8");
                totalamount+=100;

            }

            if(chk56.isChecked()==true)
            {
                checked+=1;
                result.append("F9");
                totalamount+=100;
            }

            if(chk57.isChecked()==true)
            {
                checked+=1;
                result.append("F10");
                totalamount+=100;
            }

            if(chk58.isChecked()==true)
            {
                checked+=1;
                result.append("G1");
                totalamount+=60;

            }

            if(chk59.isChecked()==true)
            {
                checked+=1;
                result.append("G2");
                totalamount+=60;
            }

            if(chk60.isChecked()==true)
            {
                checked+=1;
                result.append("G3");
                totalamount+=60;
            }


            if(chk61.isChecked()==true)
            {
                checked+=1;
                result.append("G4");
                totalamount+=60;
            }

            if(chk62.isChecked()==true)
            {
                checked+=1;
                result.append("G5");
                totalamount+=60;
            }

            if(chk63.isChecked()==true)
            {
                checked+=1;
                result.append("G6");
                totalamount+=60;

            }

            if(chk64.isChecked()==true)
            {
                checked+=1;
                result.append("G7");
                totalamount+=60;
            }

            if(chk65.isChecked()==true)
            {
                checked+=1;
                result.append("G8");
                totalamount+=60;
            }

            if(chk66.isChecked()==true)
            {
                checked+=1;
                result.append("H1");
                totalamount+=60;

            }

            if(chk67.isChecked()==true)
            {
                checked+=1;
                result.append("H2");
                totalamount+=60;
            }

            if(chk68.isChecked()==true)
            {
                checked+=1;
                result.append("H3");
                totalamount+=60;
            }

            if(chk69.isChecked()==true)
            {
                checked+=1;
                result.append("H4");
                totalamount+=60;

            }

            if(chk70.isChecked()==true)
            {
                checked+=1;
                result.append("H5");
                totalamount+=60;
            }

            if(chk71.isChecked()==true)
            {
                checked+=1;
                result.append("H6");
                totalamount+=60;
            }

            if(chk72.isChecked()==true)
            {
                checked+=1;
                result.append("H7");
                totalamount+=60;

            }

            total1.append("Totalamount:"+totalamount+"Rs");

            seatid2=result.toString();
            total2=total1.toString();

            if(checked!=seatSlot2) {
                Toast.makeText(seats_2.this, "you have to select correct no.of seats", Toast.LENGTH_LONG).show();
                return;
            }
            Intent intent = new Intent(seats_2.this, payment2.class);
            // intent.putExtra("seatId",String.valueOf(seatid1));

            intent.putExtra("Total2",String.valueOf(total2));
            startActivity(intent);
            //}





        }
    }
