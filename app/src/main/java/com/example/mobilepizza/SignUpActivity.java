package com.example.mobilepizza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.mobilepizza.Database.DatabaseConnect;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }


    public void handleAuthSubmitClick(View v){
        DatabaseConnect db = new DatabaseConnect();
        TextView userTelephone = findViewById(R.id.signup_phone);
        TextView userPassword = findViewById(R.id.signup_password);
        userPassword.getText().toString();
        userTelephone.getText().toString();

        if(db.userVerification(userPassword.getText().toString(),userTelephone.getText().toString())) {
            startActivity(new Intent(this, MainLKactivity.class));
        }
        //else
    }

    public void SwitchToRegistration(View view) {
        startActivity(new Intent(this, RegistrationActivity.class));
    }
}