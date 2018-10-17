package com.example.mahalakshumi.fireapp;

import android.Manifest;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;

import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import static java.sql.Types.NULL;

public class MainActivity extends AppCompatActivity {



    TextView tvresult;

    private Firebase mref;

    private static final int REQUEST_CALL=1;

    private EditText etnumber;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tvresult= (TextView)findViewById(R.id.tvresult);

        mref= new Firebase("https://sensordata-b2907.firebaseio.com/number");


        mref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String value=dataSnapshot.getValue(String.class);
                tvresult.setText(value);
                if(Integer.parseInt(value)<40){
                    makephonecall();
                }

            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
                tvresult.setText("unavailable") ;

            }
        });

        ImageView imagecall = findViewById(R.id.imagecall);

        ImageView imagechat =findViewById(R.id.imagechat);

        /*imagecall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                makephonecall();
            }
        });*/

        imagechat.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                gotoscreen();

            }
        });
    }


        private void makephonecall(){
        String number="7338906863";

            if (number.trim().length() > 0) {

                if (ContextCompat.checkSelfPermission(MainActivity.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
                } else {
                    String dial = "tel:" + number;
                    startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
                }

            } else {
                Toast.makeText(MainActivity.this, "Enter Phone Number", Toast.LENGTH_SHORT).show();
            }
        }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makephonecall();
            } else {
                Toast.makeText(this, "Permission DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void gotoscreen()
    {
        Intent intent;
        intent = new Intent(this, chat.class);
        startActivity(intent);
    }


    public void buclicksleep(View view) {
        Toast.makeText(MainActivity.this, "In sleep mode", Toast.LENGTH_SHORT).show();
    }

    public void buclicknormal(View view) {
        Toast.makeText(MainActivity.this, "In normal mode", Toast.LENGTH_SHORT).show();
    }


    public void buclickexercise(View view) {
        Toast.makeText(MainActivity.this, "In exercise mode", Toast.LENGTH_SHORT).show();
    }

    public void bulogout(View view) {
        Intent intent= new Intent(this,login.class);
        startActivity(intent);
    }
}


