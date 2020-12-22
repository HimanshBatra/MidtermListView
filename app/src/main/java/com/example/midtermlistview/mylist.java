package com.example.midtermlistview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class mylist extends BaseAdapter {
    private final Activity activity;
    ArrayList<Data> dataArrayList ;
    public mylist(Activity activity, ArrayList<Data> dataArrayList ) {
        this.dataArrayList=dataArrayList;
        this.activity=activity;

    }

    @Override
    public int getCount() {
        return dataArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=activity.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.listadapter, null,true);

        TextView titleText = (TextView) rowView.findViewById(R.id.repository);
        TextView subtitleText = (TextView) rowView.findViewById(R.id.owner);


        titleText.setText(dataArrayList.get(position).getId());
        subtitleText.setText(dataArrayList.get(position).getFullName());

        return rowView;

    };
}
