package com.example.universityadmissionhelpline;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Vector;

public class UniversityInfo extends AppCompatActivity {
    ListView list;

    //id of university logos
    int[] logos = {R.drawable.jnu,R.drawable.iu,R.drawable.ku,R.drawable.cu,R.drawable.jkknu,
            R.drawable.bru,R.drawable.barisal,R.drawable.rabindro,R.drawable.bsmrstu,R.drawable.hasina,
            R.drawable.sust,R.drawable.hstu,R.drawable.mbstu,R.drawable.nstu,R.drawable.just,
            R.drawable.pust,R.drawable.dub,R.drawable.rmstu,R.drawable.bmsfmstu,R.drawable.pstu};

    //requirement for gpa list
    double[] ssc_req ={2.0,2.0,2.0,2.0,2.0,2.0,3.0,3.0,3.0,3.0,3.0,3.0,3.0,4.0,4.0,4.0,4.0,4.0,4.0,4.0};
    double[] hsc_req ={2.0,2.0,2.0,2.0,2.0,2.0,3.0,3.0,3.0,3.0,3.0,3.0,3.0,4.0,4.0,4.0,4.0,4.0,4.0,4.0};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_university_info);

        //list of names of university (manually synced with logos)
        String[] universityName = getResources().getStringArray(R.array.university_name_gst);

        //users gpa as inputted in previous intent
        String SscGpa = getIntent().getStringExtra("KeySscGpa");
        String HscGpa = getIntent().getStringExtra("KeyHscGpa");

        double ssc_gpa = Double.parseDouble(SscGpa);
        double hsc_gpa = Double.parseDouble(HscGpa);

        //For creating custom list depending on inputted gpa
        ArrayList<String> displayedList = new ArrayList<String>();
        ArrayList<Integer> displayedLogos = new ArrayList<Integer>() ;

        for(int i=0,element=0;i< universityName.length;i++)
        {
            if(ssc_req[i]<=ssc_gpa && hsc_req[i]<=hsc_gpa) {
                displayedList.add(universityName[i]);
                displayedLogos.add(logos[i]);
            }
        }


        list = findViewById(R.id.university_list);
        CustomAdapter customAdapter = new CustomAdapter(this,displayedList,displayedLogos);
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