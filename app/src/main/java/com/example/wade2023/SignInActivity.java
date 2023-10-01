package com.example.wade2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.textfield.TextInputEditText;

public class SignInActivity extends AppCompatActivity
{

    private TextInputEditText etEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

    }
}