package com.example.universityadmissionhelpline;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.beans.IndexedPropertyChangeEvent;
import java.util.ArrayList;

public class UniversityInfo extends AppCompatActivity {
    ListView list;

    //id of university logos
    int[] logos = {
            R.drawable.du,R.drawable.du,R.drawable.du,R.drawable.du,R.drawable.du,
            R.drawable.ju,R.drawable.ju,R.drawable.ju,R.drawable.ju,R.drawable.ju,R.drawable.ju,R.drawable.ju,R.drawable.ju,
            R.drawable.cu, R.drawable.cu, R.drawable.cu, R.drawable.cu,
            R.drawable.ru, R.drawable.ru, R.drawable.ru, R.drawable.ru, R.drawable.ru, R.drawable.ru,
            R.drawable.jnu, R.drawable.jnu,R.drawable.jnu,R.drawable.jnu,
            R.drawable.iu,  R.drawable.iu, R.drawable.iu,
            R.drawable.ku, R.drawable.ku,R.drawable.ku,R.drawable.ku,
            R.drawable.cou, R.drawable.cou,R.drawable.cou,
            R.drawable.jkknu, R.drawable.jkknu,R.drawable.jkknu,R.drawable.jkknu,R.drawable.jkknu,
            R.drawable.bru, R.drawable.bru,R.drawable.bru,R.drawable.bru,R.drawable.bru,R.drawable.bru,
            R.drawable.barisal,R.drawable.barisal,R.drawable.barisal,
            R.drawable.rabindro,
            R.drawable.dub,
            R.drawable.hasina,
            R.drawable.sust, R.drawable.sust,R.drawable.sust,
            R.drawable.hstu, R.drawable.hstu,R.drawable.hstu,
            R.drawable.mbstu, R.drawable.mbstu,R.drawable.mbstu,
            R.drawable.nstu,R.drawable.nstu,R.drawable.nstu,R.drawable.nstu,R.drawable.nstu,R.drawable.nstu,
            R.drawable.just, R.drawable.just,R.drawable.just,R.drawable.just,
            R.drawable.pust, R.drawable.pust,R.drawable.pust,
            R.drawable.bsmrstu, R.drawable.bsmrstu, R.drawable.bsmrstu, R.drawable.bsmrstu,
            R.drawable.rmstu,
            R.drawable.bmsfmstu,R.drawable.bmsfmstu,
            R.drawable.pstu, R.drawable.pstu,R.drawable.pstu,R.drawable.pstu,R.drawable.pstu,
    };

    //requirement for gpa list
    double[] ssc_req ={2.0,2.0,2.0,2.0,2.0,2.0,3.0,3.0,3.0,3.0,3.0,3.0,3.0,4.0,4.0,4.0,4.0,4.0,4.0,4.0,
                       2.0,2.0,2.0,2.0,2.0,2.0,3.0,3.0,3.0,3.0,3.0,3.0,3.0,4.0,4.0,4.0,4.0,4.0,4.0,4.0,
                       2.0,2.0,2.0,2.0,2.0,2.0,3.0,3.0,3.0,3.0,3.0,3.0,3.0,4.0,4.0,4.0,4.0,4.0,4.0,4.0,
                       2.0,2.0,2.0,2.0,2.0,2.0,3.0,3.0,3.0,3.0,3.0,3.0,3.0,4.0,4.0,4.0,4.0,4.0,4.0,4.0,
                       2.0,2.0,2.0,2.0,2.0,2.0,3.0,3.0,3.0,3.0,3.0,3.0,3.0,4.0,4.0,4.0,4.0,4.0,4.0,4.0,
    };

    double[] hsc_req ={2.0,2.0,2.0,2.0,2.0,2.0,3.0,3.0,3.0,3.0,3.0,3.0,3.0,4.0,4.0,4.0,4.0,4.0,4.0,4.0,
                       2.0,2.0,2.0,2.0,2.0,2.0,3.0,3.0,3.0,3.0,3.0,3.0,3.0,4.0,4.0,4.0,4.0,4.0,4.0,4.0,
                       2.0,2.0,2.0,2.0,2.0,2.0,3.0,3.0,3.0,3.0,3.0,3.0,3.0,4.0,4.0,4.0,4.0,4.0,4.0,4.0,
                       2.0,2.0,2.0,2.0,2.0,2.0,3.0,3.0,3.0,3.0,3.0,3.0,3.0,4.0,4.0,4.0,4.0,4.0,4.0,4.0,
                       2.0,2.0,2.0,2.0,2.0,2.0,3.0,3.0,3.0,3.0,3.0,3.0,3.0,4.0,4.0,4.0,4.0,4.0,4.0,4.0
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_university_info);

        //list of names of university (manually synced with logos)
        String[] universityName = getResources().getStringArray(R.array.unit_wise_university_name);
    try {
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
    }catch (Exception e){
        Toast.makeText(UniversityInfo.this, "Enter Gpa", Toast.LENGTH_SHORT).show();
    };

    }
}