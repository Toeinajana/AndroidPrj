package com.example.a2020project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Login_form extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);
        getSupportActionBar().setTitle("Login");
    }

    public void btn_signup(View view) {
        Intent SignupIntent = new Intent(Login_form.this, Signup_Form.class);
        startActivity(SignupIntent);
    }
}
