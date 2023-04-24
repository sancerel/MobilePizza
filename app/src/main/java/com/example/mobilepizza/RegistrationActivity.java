package com.example.mobilepizza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegistrationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

    }

    public void handleSubmitClick(View v){
        //проверить не зарегистрирован ли уже юзер
            // если да то редиректим на страницу авторизации

        //если нет то заносим в бд
        TextView userName = findViewById(R.id.editTextTextPersonName);
        TextView userEmail = findViewById(R.id.editTextTextEmailAddress);
        TextView userPassword = findViewById(R.id.editTextTextPassword);
        HashMap<String,String> userData = new HashMap<>(); // мапа содержит данные полей

        userData.put("user_name", userName.getText().toString());
        userData.put("user_email", userEmail.getText().toString());
        userData.put("user_password", userPassword.getText().toString());

        startActivity(new Intent(this,ProfileActivity.class));
    }


}