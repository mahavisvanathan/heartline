package com.example.mahalakshumi.fireapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class login extends AppCompatActivity {

    TextView tvregister;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tvregister = (TextView)findViewById(R.id.tvregister);

        tvregister.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                gotoregistration();

            }
        });
    }

    public void bulogin(View view) {
        Intent intent= new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void gotoregistration(){
        Intent intent= new Intent(this,registration.class);
        startActivity(intent);
    }




}
