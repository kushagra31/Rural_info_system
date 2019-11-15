package com.example.rural_info_system;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class State extends AppCompatActivity implements GetStateInterface{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state);

        new AsyncTas(this, State.this).execute();




    }

    @Override
    public void onCarsCompleted(ArrayList<String> arrayList) {

        List<String> results = arrayList;

        ListView listView =(ListView) findViewById(R.id.listview);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, results);
    listView.setAdapter(adapter);
    }

    @Override
    public void onCarsError(String error) {

    }
}
