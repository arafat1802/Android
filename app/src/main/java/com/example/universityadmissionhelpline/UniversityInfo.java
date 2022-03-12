package com.example.universityadmissionhelpline;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class UniversityInfo extends AppCompatActivity {
    ListView list;

    int[] logos = {R.drawable.jnu,R.drawable.iu,R.drawable.ku,R.drawable.cu,R.drawable.jkknu,
            R.drawable.bru,R.drawable.barisal,R.drawable.rabindro,R.drawable.bsmrstu,R.drawable.hasina,
            R.drawable.sust,R.drawable.hstu,R.drawable.mbstu,R.drawable.nstu,R.drawable.just,
            R.drawable.pust,R.drawable.dub,R.drawable.rmstu,R.drawable.bmsfmstu,R.drawable.pstu};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_university_info);

        String[] universityName = getResources().getStringArray(R.array.university_name_gst);

        list = findViewById(R.id.university_list);
        CustomAdapter customAdapter = new CustomAdapter(this,universityName,logos);
        list.setAdapter(customAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = universityName[position];
                Toast.makeText(UniversityInfo.this, value, Toast.LENGTH_SHORT).show();
            }
        });

    }
}