package com.example.rural_info_system;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        Button button = (Button) findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextInputEditText textInputEditText=(TextInputEditText) findViewById(R.id.edit1);
                String a= textInputEditText.getText().toString();

                TextInputEditText textInputEditText1=(TextInputEditText) findViewById(R.id.edit2);
                String b= textInputEditText1.getText().toString();
                if(a.isEmpty()){
                    Toast.makeText(MainActivity.this,"Enter Username",Toast.LENGTH_SHORT).show();

                }else if(b.isEmpty()){
                    Toast.makeText(MainActivity.this,"Enter Password",Toast.LENGTH_SHORT).show();
                }
                else {
                    new AsyncTas(MainActivity.this).execute();
                    startActivity(new Intent(getApplicationContext(), Main2Activity.class));
                    finish();
                }
            }
        });

    }

}
