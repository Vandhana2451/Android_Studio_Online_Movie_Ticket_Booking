package com.example.project;

import static com.example.project.date_time.dateSlot1;
import static com.example.project.date_time.timeSlot1;
import static com.example.project.date_time_2.dateSlot2;
import static com.example.project.date_time_2.timeSlot2;
import static com.example.project.seats.seatid1;
import static com.example.project.seats_2.seatid2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class confirm2 extends AppCompatActivity {
    Button b;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm2);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        tv = findViewById(R.id.tot);
        Intent intent=getIntent();
        String total=intent.getExtras().getString("Total2");
        tv.setText(total);

        b=(Button)findViewById(R.id.button2);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent1=new Intent(confirm2.this,finalpage2.class);
                intent1.putExtra("date2",String.valueOf(dateSlot2));
                intent1.putExtra("time2",String.valueOf(timeSlot2));
                intent1.putExtra("seatId2",String.valueOf(seatid2));
                //intent1.putExtra("seatId2",String.valueOf(seatid2));
                //intent1.putExtra("seatId3",String.valueOf(seatid3));

                startActivity(intent1);
            }


        });

    }
}