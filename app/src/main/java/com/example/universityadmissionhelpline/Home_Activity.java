package com.example.universityadmissionhelpline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home_Activity extends AppCompatActivity {
    private Button gst,nongst,medical,agri,engi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        gst = (Button) findViewById(R.id.gst_Button);
        nongst = (Button) findViewById(R.id.nongst_btn);
        medical = (Button) findViewById(R.id.medical_button);
        agri = (Button) findViewById(R.id.agriculture_button);
        engi = (Button) findViewById(R.id.engineering_id);
        gst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home_Activity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        nongst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(Home_Activity.this, NonGst.class);
                startActivity(intent);
            }
        });
        medical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        agri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        engi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home_Activity.this, Engineering.class);
                startActivity(intent);
            }
        });
    }
}