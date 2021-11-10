package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.DocumentsContract;
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
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class finalpage extends AppCompatActivity {
TextView tv,tv1,tv2;
//Button btnpdf,btnview;
private FirebaseUser user;
private DatabaseReference reference;
private String userid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalpage);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        tv = findViewById(R.id.textView6);
        tv1 = findViewById(R.id.textView5);
        tv2 = findViewById(R.id.time);
       // btnpdf=(Button)findViewById(R.id.btnpdf);
        //btnview=(Button)findViewById(R.id.btnview);

        Intent intent1=getIntent();

        String seatId=intent1.getExtras().getString("seatId");
        String date1=intent1.getExtras().getString("date1");
        String time1=intent1.getExtras().getString("time1");
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
                Toast.makeText(finalpage.this,"Something went wrong",Toast.LENGTH_LONG).show();


            }
        });

      /* btnpdf.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String Username=user_name.getText().toString();
               String tvpdf=tv.getText().toString();
               String tvpdf1=tv1.getText().toString();
               String tvpdf2=tv2.getText().toString();
               String path=getExternalFilesDir(null).toString()+"/user.pdf";
               File file=new File(path);

               if(!file.exists()) {
                   try {
                       file.createNewFile();
                   } catch (IOException e) {
                       e.printStackTrace();
                   }
               }
               Document document=new Document(PageSize.A4);
               try {
                   PdfWriter.getInstance(document,new FileOutputStream(file.getAbsoluteFile()));
               } catch (DocumentException e) {
                   e.printStackTrace();
               } catch (FileNotFoundException e) {
                   e.printStackTrace();
               }
               document.open();

               Font myfont=new Font(Font.FontFamily.HELVETICA,24,Font.BOLD);

               Paragraph paragraph=new Paragraph();
               paragraph.add(new Paragraph("user name:"+Username,myfont));
               paragraph.add(new Paragraph("\n") );
               paragraph.add(new Paragraph("Seat"+tvpdf));
               paragraph.add(new Paragraph("\n"));
               paragraph.add(new Paragraph("Date"+tvpdf1));
               paragraph.add(new Paragraph("\n"));
               paragraph.add(new Paragraph("Time"+tvpdf2));
               paragraph.add(new Paragraph("\n"));




               try {
                   document.add(paragraph);
               } catch (DocumentException e) {
                   e.printStackTrace();
               }

               document.close();

               Toast.makeText(finalpage.this, "PDF Created Succcessfully", Toast.LENGTH_SHORT).show();

           }
       });
       btnview.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(getApplicationContext(),newactivity.class);
               startActivity(intent);
           }
       });*/


    }
}