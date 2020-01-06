package com.example.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdminActivity extends AppCompatActivity {

    private EditText nametxt,desgtxt,locationtxt;
    DatabaseReference databaseReference;
    //private TextView signInTextView;
    private Button submitbtn;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        databaseReference = FirebaseDatabase.getInstance().getReference("Doctors");

        nametxt = findViewById(R.id.DoctorName);
        desgtxt=findViewById(R.id.DesignationDct);
        locationtxt=findViewById(R.id.LctDct);
        submitbtn=findViewById(R.id.submitDct);

        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
        });

    }

    private void saveData() {

        String name = nametxt.getText().toString().trim();
        String designation = desgtxt.getText().toString().trim();
        String location=locationtxt.getText().toString().trim();

        String key = databaseReference.push().getKey();

        InfoDct infoDct = new InfoDct(name,designation,location);

        databaseReference.child(key).setValue(infoDct);

        Toast.makeText(getApplicationContext(),"Doctor Info is Added",Toast.LENGTH_SHORT).show();

        nametxt.setText("");
        desgtxt.setText("");
        locationtxt.setText("");

    }

}
