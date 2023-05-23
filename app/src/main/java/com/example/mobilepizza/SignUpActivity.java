package com.example.mobilepizza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }


    public void handleAuthSubmitClick(View v){
        //проверить логин, пароль
        TextView userLogin = findViewById(R.id.signup_login);
        TextView userPassword = findViewById(R.id.signup_password);


        startActivity(new Intent(this, MainLKactivity.class));
    }
}