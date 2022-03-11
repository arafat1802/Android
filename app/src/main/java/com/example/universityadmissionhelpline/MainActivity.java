package com.example.universityadmissionhelpline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    Button search_btn;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.sub_spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.sub_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        /* Add all options for spinner with corresponding hints */

        EditText editText = findViewById(R.id.sub_a);
        if(spinner.getSelectedItem().toString().equals("Arts"))
        {
            editText.setHint("Arts");
        }
        else if(spinner.getSelectedItem().toString().equals("Science"))
        {
            editText.setHint("Science");
        }
        else if(spinner.getSelectedItem().toString().equals("Commerce"))
        {
            editText.setHint("Commerce");
        }

        search_btn = (Button) findViewById(R.id.search_button);
        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, UniversityInfo.class);
                startActivity(intent);

            }
        });

    }
}