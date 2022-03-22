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
    EditText GpaInputSsc,GpaInputHsc;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.sub_spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.sub_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        search_btn = (Button) findViewById(R.id.search_button);
        GpaInputSsc = findViewById(R.id.ssc_gpa);
        GpaInputHsc = findViewById(R.id.hsc_gpa);

        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ssc_gpa = GpaInputSsc.getText().toString();
                String hsc_gpa = GpaInputHsc.getText().toString();

                Intent intent = new Intent(MainActivity.this, UniversityInfo.class);
                intent.putExtra("KeySscGpa",ssc_gpa);
                intent.putExtra("KeyHscGpa",hsc_gpa);

                startActivity(intent);
            }
        });

    }
}
