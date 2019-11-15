package com.example.rural_info_system;

import android.content.Intent;
import android.os.Bundle;

import com.squareup.picasso.Picasso;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    ArrayList<String> stateslist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        ImageView im =
                (ImageView) findViewById(R.id.imageView);
        Picasso.get().load("http://www.panna.org/sites/default/files/styles/blog_lead_image/public/blog/kids-smiley.jpg?itok=6s1SrbuZ").fit().into(im);

        Button button, button4, button3;
        button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(), DistrictActivity.class));


            }
        });

        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startActivity(new Intent(getApplicationContext(), State.class));


            }
        });


        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startActivity(new Intent(getApplicationContext(), State.class));


            }
        });


    }

}
