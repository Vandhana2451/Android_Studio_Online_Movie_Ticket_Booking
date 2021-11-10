package com.example.project;

import static com.example.project.date_time.dateSlot1;
import static com.example.project.date_time.timeSlot1;
import static com.example.project.seats.seatid1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class confirm extends AppCompatActivity {
    Button b;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        tv = findViewById(R.id.tot);
        Intent intent=getIntent();
        String total=intent.getExtras().getString("Total");
        tv.setText(total);

        b=(Button)findViewById(R.id.button2);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent1=new Intent(confirm.this,finalpage.class);
                intent1.putExtra("date1",String.valueOf(dateSlot1));
                intent1.putExtra("time1",String.valueOf(timeSlot1));
                intent1.putExtra("seatId",String.valueOf(seatid1));
                //intent1.putExtra("seatId2",String.valueOf(seatid2));
                //intent1.putExtra("seatId3",String.valueOf(seatid3));

                startActivity(intent1);
            }


        });

    }
}