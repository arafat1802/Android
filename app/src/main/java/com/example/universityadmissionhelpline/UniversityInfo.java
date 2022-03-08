package com.example.universityadmissionhelpline;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class UniversityInfo extends AppCompatActivity {
    private ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_university_info);

        list = findViewById(R.id.university_list);
        String[] universityName = getResources().getStringArray(R.array.university_name);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(UniversityInfo.this,R.layout.uni_item,
                R.id.text_view_id, universityName);

        list.setAdapter(arrayAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = universityName[position];
                Toast.makeText(UniversityInfo.this, value, Toast.LENGTH_SHORT).show();
            }
        });

    }
}