package com.example.wade2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class SignInActivity extends AppCompatActivity
{


    private TextInputEditText etEmail;
    private TextInputEditText etPassword;
    private Button btnSignIn1;
    private Button btnSingUp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        etPassword=findViewById(R.id.etPassword);
        etEmail=findViewById(R.id.etEmail);
        btnSingUp2=findViewById(R.id.btnSingUp2);
        btnSignIn1=findViewById(R.id.btnSignIn1);





    }
    public void onclickSignUp(View v)
    {

        Intent i= new Intent(SignInActivity.this, SignUpActivity.class);
        startActivity(i);

    }
    public  void onclicksignIn(View v)
    {
        checkEmailPassw();
    }
    private void checkEmailPassw()
    {
        boolean isAllok =true;
        String email=etEmail.getText().toString();
        String password=etPassword.getText().toString();
        if(email.length()<6 || email.contains("@")==false)
        {
            isAllok = false;
            etEmail.setError("Wrong Email");
        }
        if(password.length()< 8 || password.contains(" ")==true) {
            isAllok = false;
            etPassword.setError("Wrong password");
        }
        if(isAllok)
        {
            Toast.makeText(this, "ALL OK", Toast.LENGTH_SHORT).show();
        }
    }
}