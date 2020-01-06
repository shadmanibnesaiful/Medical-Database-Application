package com.example.myloginapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.google.firebase.auth.FirebaseAuth;

public class ProfileActivity extends AppCompatActivity {

    Button button;
    CheckBox Medicine, Surgeon, Cardiologist, Pediatrician;

    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mAuth=FirebaseAuth.getInstance();


        button=findViewById(R.id.buttonsymptom);
        Medicine=findViewById(R.id.medicineid);
        Surgeon=findViewById(R.id.surgeonid);
        Cardiologist=findViewById(R.id.cardiologistid);
        Pediatrician=findViewById(R.id.pediatricianid);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value="";
                if (Medicine.isChecked())
                {
                    value=Medicine.getText().toString();
                }
                if (Surgeon.isChecked())
                {
                    value=Surgeon.getText().toString();
                }
                if (Cardiologist.isChecked())
                {
                    value=Cardiologist.getText().toString();
                }
                if (Pediatrician.isChecked())
                {
                    value=Pediatrician.getText().toString();
                }
                Intent i=new Intent(ProfileActivity.this,third.class);
                i.putExtra("tag",value);
                startActivity(i);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_layout,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.signOutMenuId)
        {
            FirebaseAuth.getInstance().signOut();
            finish();
            Intent intent=new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
