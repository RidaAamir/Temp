package com.example.emad.splashscreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashLoading extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_loading);
        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(2000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    Intent intent = new Intent(SplashLoading.this,SelectTeam.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        timerThread.start();
    }
}

