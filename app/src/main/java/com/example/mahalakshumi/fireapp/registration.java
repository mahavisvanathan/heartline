package com.example.mahalakshumi.fireapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
    }

    public void buregister1(View view) {
        Intent intent;
        intent = new Intent(this, login.class);
        startActivity(intent);

    }
}
