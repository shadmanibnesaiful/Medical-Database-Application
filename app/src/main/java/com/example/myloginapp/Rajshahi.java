package com.example.myloginapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Rajshahi extends AppCompatActivity {

    private ListView listView;
    DatabaseReference databaseReference;

    private List<InfoDct> doctorlist;
    private CustomAdapter customAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rajshahi);

        databaseReference = FirebaseDatabase.getInstance().getReference("Doctors");

        doctorlist = new ArrayList<>();
        customAdapter = new CustomAdapter(Rajshahi.this,doctorlist);

        listView = findViewById(R.id.listviwid);





        /*Bundle b=getIntent().getExtras();
        String s1=b.getString("tag");
        String s2=b.getString("tag2");

        Toast.makeText(Rajshahi.this,s1+" "+s2, Toast.LENGTH_SHORT).show();*/

    }

    @Override
    protected void onStart() {

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                doctorlist.clear();

                for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
                {
                    InfoDct infoDct = dataSnapshot1.getValue(InfoDct.class);
                    doctorlist.add(infoDct);
                }

                listView.setAdapter(customAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        super.onStart();
    }
}
