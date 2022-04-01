package com.example.universityadmissionhelpline;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    ArrayList<Integer> logos;
    ArrayList<String> universityName;
    Context context;
    LayoutInflater inflater;

    CustomAdapter(Context context, ArrayList<String> universityName,ArrayList<Integer> logos){
        this.context = context;
        this.universityName = universityName;
        this.logos = logos;
    }
    @Override
    public int getCount() {
        return universityName.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        if(convertView==null)
        {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.uni_item,viewGroup,false);
        }

        ImageView imageView = (ImageView) convertView.findViewById(R.id.varsity_logo);
        TextView textView = (TextView) convertView.findViewById(R.id.varsity_name_id);


        //TextView linkTextView = convertView.findViewById(R.id.apply_link);
        //linkTextView.setMovementMethod(LinkMovementMethod.getInstance());

        imageView.setImageResource(logos.get(position));
        textView.setText(universityName.get(position));

        return convertView;
    }
}
