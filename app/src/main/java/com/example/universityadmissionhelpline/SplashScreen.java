package com.example.universityadmissionhelpline;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Ringtone;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class SplashScreen extends AppCompatActivity {
    private ProgressBar progressBar;
    private  double progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        progressBar = (ProgressBar) findViewById(R.id.progressBarId);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
            }
        });

        thread.start();
    }

    public void doWork() {
        for(progress = 0.1; progress <= 100; progress +=0.1){
            try {
                Thread.sleep(1);
                progressBar.setProgress((int) progress);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();

    }
}