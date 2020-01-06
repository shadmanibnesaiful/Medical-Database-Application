package com.example.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class Rangpur extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rangpur);

        Bundle b=getIntent().getExtras();
        String s1=b.getString("tag");
        String s2=b.getString("tag2");

        Toast.makeText(Rangpur.this,s1+" "+s2, Toast.LENGTH_SHORT).show();


    }
}
