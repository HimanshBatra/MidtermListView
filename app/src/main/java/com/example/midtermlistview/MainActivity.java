package com.example.midtermlistview;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView list;
//
//    String[] RepositoryName ={
//            "repo1","repo2",
//            "repo3","repo4",
//            "repo5",
//    };
//
//    String[] Ownername ={
//            "owner1"," owner2",
//            "owner3","owner4",
//            "owner5",
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#46a0f0"));
        actionBar.setBackgroundDrawable(colorDrawable);
        GetData getData= new GetData(MainActivity.this);
        getData.execute("https://api.github.com/repositories");

    }
}