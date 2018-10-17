package com.example.mahalakshumi.fireapp;

import android.app.Application;

import com.firebase.client.Firebase;

public class fireapp extends Application
{

    public void onCreate()
    {
            super.onCreate();

            Firebase.setAndroidContext(this);
        }

}
