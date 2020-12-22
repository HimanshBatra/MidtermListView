package com.example.midtermlistview;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.TextView;

public class DataDetail extends AppCompatActivity {
    TextView id;
    TextView nodeid;
    TextView fullname;
    TextView language;
    TextView event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_detail);
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#46a0f0"));
        actionBar.setBackgroundDrawable(colorDrawable);
        id=findViewById(R.id.id);
        nodeid=findViewById(R.id.nodeid);
        fullname=findViewById(R.id.fullname);
        language=findViewById(R.id.language);
        event=findViewById(R.id.event);

        Intent intent=getIntent();
        Data data=intent.getParcelableExtra("dataDetail");
        id.setText(data.getNodeId());
        nodeid.setText(data.getNodeId());
        fullname.setText(data.getFullName());
        language.setText(data.getLanguageUrl());
        event.setText(data.getEventsUrl());
    }
}