package com.example.project;

import static com.example.project.date_time.dateSlot1;
import static com.example.project.date_time.timeSlot1;
import static com.example.project.date_time_2.dateSlot2;
import static com.example.project.date_time_2.timeSlot2;
import static com.example.project.date_time_3.dateSlot3;
import static com.example.project.date_time_3.timeSlot3;
import static com.example.project.seats.seatid1;
import static com.example.project.seats.total;
import static com.example.project.seats_2.seatid2;
import static com.example.project.seats_2.total2;
import static com.example.project.seats_3.seatid3;

import java.lang.reflect.Field;
import java.util.Calendar;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class payment2 extends AppCompatActivity implements OnClickListener {
    static final int DATE_DIALOG_ID = 1;
    private EditText e1, e2, e3;
    private int mYear;
    private int mMonth;
    private int mDay;
    private EditText etPickADate;
    TextView tv;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment2);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        etPickADate = (EditText) findViewById(R.id.et_datePicker);
        e1 = (EditText) findViewById(R.id.editTextTextPersonName);
        e2 = (EditText) findViewById(R.id.editTextTextPersonName2);
        e3 = (EditText) findViewById(R.id.editTextTextPersonName3);
        tv = findViewById(R.id.total);
        Intent intent=getIntent();
        String total=intent.getExtras().getString("Total2");
        tv.setText(total);


        b = (Button) findViewById(R.id.otp);
        b.setOnClickListener(this);

        etPickADate.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                showDialog(DATE_DIALOG_ID);
            }
        });

        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
    }

    DatePickerDialog.OnDateSetListener mDateSetListner = new OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {

            mYear = year;
            mMonth = monthOfYear;
            mDay = dayOfMonth;
            updateDate();
        }
    };

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                /*
                 * return new DatePickerDialog(this, mDateSetListner, mYear, mMonth,
                 * mDay);
                 */
                DatePickerDialog datePickerDialog = this.customDatePicker();
                return datePickerDialog;
        }
        return null;
    }

    protected void updateDate() {
        int localMonth = (mMonth + 1);
        String monthString = localMonth < 10 ? "0" + localMonth : Integer
                .toString(localMonth);
        String localYear = Integer.toString(mYear).substring(2);
        etPickADate.setText(new StringBuilder()
                // Month is 0 based so add 1
                .append(monthString).append("/").append(localYear).append(" "));
        showDialog(DATE_DIALOG_ID);
    }

    private DatePickerDialog customDatePicker() {
        DatePickerDialog dpd = new DatePickerDialog(this, mDateSetListner,
                mYear, mMonth, mDay);
        try {

            Field[] datePickerDialogFields = dpd.getClass().getDeclaredFields();
            for (Field datePickerDialogField : datePickerDialogFields) {
                if (datePickerDialogField.getName().equals("mDatePicker")) {
                    datePickerDialogField.setAccessible(true);
                    DatePicker datePicker = (DatePicker) datePickerDialogField
                            .get(dpd);
                    Field datePickerFields[] = datePickerDialogField.getType()
                            .getDeclaredFields();
                    for (Field datePickerField : datePickerFields) {
                        if ("mDayPicker".equals(datePickerField.getName())
                                || "mDaySpinner".equals(datePickerField
                                .getName())) {
                            datePickerField.setAccessible(true);
                            Object dayPicker = new Object();
                            dayPicker = datePickerField.get(datePicker);
                            ((View) dayPicker).setVisibility(View.GONE);
                        }
                    }
                }

            }
        } catch (Exception ex) {
        }
        return dpd;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.otp:
                button();
                break;
        }

    }

    private void button() {
        String cardnum = e1.getText().toString().trim();
        String cvv = e2.getText().toString().trim();
        String phn = e3.getText().toString().trim();

        if (cardnum.isEmpty()) {
            e1.setError("Card Number  is required");
            e1.requestFocus();
            return;
        }
        if (cardnum.length()>16){
            e1.setError("Card Number exceeds");
            e1.requestFocus();
            return;

        }

        if (cardnum.length()<16){
            e1.setError("Card Number must have 16 digits");
            e1.requestFocus();
            return;

        }
        if (cvv.isEmpty()) {
            e2.setError("CVV is required");
            e2.requestFocus();
            return;
        }
        if (cvv.length()>3){
            e2.setError("CVV number exceeds");
            e2.requestFocus();
            return;
        }
        if (cvv.length()<3){
            e2.setError("CVV number must have 3 digits");
            e2.requestFocus();
            return;
        }
        if (phn.isEmpty()) {
            e3.setError("Phone number is required");
            e3.requestFocus();
            return;
        }

        if (phn.length()>10) {
            e3.setError("Phone number exceeds");
            e3.requestFocus();
            return;
        }
        if (phn.length()<10) {
            e3.setError("Invalid Phone number");
            e3.requestFocus();
            return;
        }



        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent1=new Intent(payment2.this,confirm2.class);
                //intent1.putExtra("date2",String.valueOf(dateSlot2));
                //intent1.putExtra("time2",String.valueOf(timeSlot2));
                //intent1.putExtra("seatId",String.valueOf(seatid1));
                //intent1.putExtra("seatId2",String.valueOf(seatid2));
                //intent1.putExtra("seatId3",String.valueOf(seatid3));
                intent1.putExtra("Total2",String.valueOf(total2));

                startActivity(intent1);
            }


        });


    }
}


