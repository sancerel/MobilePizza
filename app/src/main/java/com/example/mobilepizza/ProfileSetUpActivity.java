package com.example.mobilepizza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ProfileSetUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_setup);

        // поменять кнопку
    }

    public void handleSetUpSubmitClick(View v){
        // забить в БД инфу о пользователе

        startActivity(new Intent(this, MainLKactivity.class));
    }
}