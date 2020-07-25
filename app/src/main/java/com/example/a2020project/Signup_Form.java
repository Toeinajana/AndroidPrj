package com.example.a2020project;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signup_Form extends AppCompatActivity {
    EditText fullname, lastname, dob, email, cfpassword, password;
    Button signup;
    Database db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_form);
        getSupportActionBar().setTitle("Register");

        fullname = findViewById(R.id.fullname);
        lastname = findViewById(R.id.lastname);
        dob = findViewById(R.id.dob);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        cfpassword = findViewById(R.id.cfpassword);
        signup = findViewById(R.id.signup_btn);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String getFullname =  fullname.getText().toString();
                String getLastname =  lastname.getText().toString();
                String getDob =  dob.getText().toString();
                String getEmail =  email.getText().toString();
                String getPassword =  password.getText().toString();
                String getCfPassword = cfpassword.getText().toString();

                if(getEmail.length() > 1){
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("Fullname", getFullname);
                    contentValues.put("Lastname", getLastname);
                    contentValues.put("Email", getEmail);
                    contentValues.put("DOB", getDob);
                    contentValues.put("Password", getPassword);
                    contentValues.put("CfPassword", getCfPassword);

                    db.addUser(contentValues);
                    Toast.makeText(Signup_Form.this, "Register Successful", Toast.LENGTH_SHORT).show();

                }
                else {

                    Toast.makeText(Signup_Form.this, "Please fill the details", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
