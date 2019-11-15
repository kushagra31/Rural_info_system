package com.example.rural_info_system;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class DistrictActivity extends AppCompatActivity implements GetStateInterface{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_district);

        new AsyncTas(this,DistrictActivity.this).execute();




    }

    @Override
    public void onCarsCompleted(ArrayList<String> arrayList) {

        List<String> results1 = arrayList;
        System.out.println("zzzzzzzzzzzzzzzzzzzzzzzzzz"+results1);
        ListView listView1 =(ListView) findViewById(R.id.dist);

        listView1.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1, results1));
    }

    @Override
    public void onCarsError(String error) {

    }
}
