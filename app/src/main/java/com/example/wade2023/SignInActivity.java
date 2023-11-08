package com.example.wade2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;

public class SignInActivity extends AppCompatActivity
{

    private TextInputEditText etEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

    }
    public void onclickGo1(View v)
    {

        Intent i= new Intent(SignInActivity.this, SignUpActivity.class);
        startActivity(i);
        finish();
    }
    public void onclickGo2(View v)
    {

        Intent i= new Intent(SignInActivity.this, SignInActivity.class);
        startActivity(i);
        finish();
    }
}