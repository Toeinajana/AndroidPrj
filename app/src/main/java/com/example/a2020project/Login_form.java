package com.example.a2020project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login_form extends AppCompatActivity {

    EditText email, password;
    Button login, signup;
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);
        getSupportActionBar().setTitle("Login");

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login_btn);
        signup = findViewById(R.id.signup_btn);
        db = new Database(this);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String getEmail =  email.getText().toString();
               String getPassword =  password.getText().toString();

               if(db.isLoginValid(getEmail, getPassword)){
                   Intent intent = new Intent (Login_form.this, Home.class);
                   startActivity(intent);
                   Toast.makeText(Login_form.this,"Login Successful", Toast.LENGTH_SHORT).show();
               }
               else {
                   Toast.makeText(Login_form.this, "Your Email or Password incorrect", Toast.LENGTH_SHORT).show();
               }

            }
        });
    }

    public void btn_signup(View view) {
        Intent SignupIntent = new Intent(Login_form.this, Signup_Form.class);
        startActivity(SignupIntent);
    }
}
