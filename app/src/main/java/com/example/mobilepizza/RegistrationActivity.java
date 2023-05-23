package com.example.mobilepizza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.mobilepizza.Database.DatabaseConnect;

import java.util.HashMap;

public class RegistrationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


    }

    public void handleRegSubmitClick(View v){
        DatabaseConnect db = new DatabaseConnect();
        /*TextView userTelephone = findViewById(R.id.signup_phone);
        TextView userEmail = findViewById(R.id.singup_email);
        TextView userPassword = findViewById(R.id.signup_password);
        HashMap<String,String> userData = new HashMap<>();
        userData.put("user_telephone", userTelephone.getText().toString());
        userData.put("user_email", userEmail.getText().toString());
        userData.put("user_password", userPassword.getText().toString());*/
        /*String args[] = {
                userTelephone.getText().toString(),
                userEmail.getText().toString(),
                userPassword.getText().toString()};*/
        db.InsertUser();
        //db.Inseart();
        //startActivity(new Intent(this, ProfileSetUpActivity.class));
    }
}