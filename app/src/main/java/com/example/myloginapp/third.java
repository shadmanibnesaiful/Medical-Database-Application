package com.example.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class third extends AppCompatActivity {
    Button button;
    CheckBox Dhaka, Rajshahi, Rangpur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        button=findViewById(R.id.buttonlocation);
        Dhaka=findViewById(R.id.dhakaid);
        Rajshahi=findViewById(R.id.rajshahiid);
        Rangpur=findViewById(R.id.rangpurid);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value="";
                if (Dhaka.isChecked())
                {
                    value=Dhaka.getText().toString();
                    Intent i=new Intent(third.this,Dhaka.class);
                    i.putExtra("tag2",value);
                    Bundle b=getIntent().getExtras();
                    String value2 = b.getString("tag");
                    i.putExtra("tag", value2);
                    startActivity(i);
                }
                if (Rajshahi.isChecked())
                {
                    value=Rajshahi.getText().toString();
                    Intent i=new Intent(third.this,Rajshahi.class);
                    i.putExtra("tag2",value);
                    Bundle b=getIntent().getExtras();
                    String value2 = b.getString("tag");
                    i.putExtra("tag", value2);
                    startActivity(i);
                }
                if (Rangpur.isChecked())
                {
                    value=Rangpur.getText().toString();
                    Intent i=new Intent(third.this,Rangpur.class);
                    i.putExtra("tag2",value);
                    Bundle b=getIntent().getExtras();
                    String value2 = b.getString("tag");
                    i.putExtra("tag", value2);
                    startActivity(i);
                }
                /*Intent i=new Intent(third.this,fourth.class);
                i.putExtra("tag2",value);
                Bundle b=getIntent().getExtras();
                String value2 = b.getString("tag");
                i.putExtra("tag", value2);
                startActivity(i);*/
            }
        });



    }
}
