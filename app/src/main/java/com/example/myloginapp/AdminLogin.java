package com.example.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLogin extends AppCompatActivity {

    private EditText adminemail, adminpass;
    private Button AdminLog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        adminemail = findViewById(R.id.AdminEmail);
        adminpass = findViewById(R.id.AdminPass);
        AdminLog = findViewById(R.id.AdminLogin);

        AdminLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String string = adminemail.getText().toString();
                String string2 = adminpass.getText().toString();

                if (string.equals("admin@gmail.com") && string2.equals("12345678"))
                {
                    Intent i = new Intent(AdminLogin.this, AdminActivity.class);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Login Unsuccessful",Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}
