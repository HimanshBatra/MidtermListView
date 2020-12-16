package com.example.midtermlistview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class mylist extends ArrayAdapter<String> {
    private final Activity activity;
    private final ArrayList RepositoryName;
    private final ArrayList Ownername;
    public mylist(Activity activity, ArrayList RepositoryName, ArrayList Ownername) {
        super(activity, R.layout.listadapter, RepositoryName);
        this.activity=activity;
        this.RepositoryName=RepositoryName;
        this.Ownername=Ownername;


    }
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=activity.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.listadapter, null,true);

        TextView titleText = (TextView) rowView.findViewById(R.id.repository);
        TextView subtitleText = (TextView) rowView.findViewById(R.id.owner);

        titleText.setText(RepositoryName.get(position).toString());
        subtitleText.setText(Ownername.get(position).toString());

        return rowView;

    };
}
