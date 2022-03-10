package com.example.universityadmissionhelpline;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    int[] logos;
    String[] universityName;
    Context context;

    LayoutInflater inflater;

    CustomAdapter(Context context,String[] universityName,int[] logos){
        this.context = context;
        this.universityName = universityName;
        this.logos = logos;
    }
    @Override
    public int getCount() {
        return universityName.length;
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

        imageView.setImageResource(logos[position]);
        textView.setText(universityName[position]);

        return convertView;
    }
}
