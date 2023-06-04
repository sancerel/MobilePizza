package com.example.mobilepizza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobilepizza.Database.DatabaseConnect;

import java.util.HashMap;


public class RegistrationActivity extends AppCompatActivity {
    TextView label;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        //TextView error = findViewById(R.id.error);
       // Button btn_reg = findViewById(R.id.setup_submit_btn2);
       // btn_reg.setOnClickListener(new View.OnClickListener() {
            /*@Override
            public void onClick(View v) {
                showInfo(error.getText().toString());
            }*/
        /*});*/
    }
    /*public void regCkick(View v){

    }*/

    /*private void showInfo(String text){
        Toast.makeText(this,text,Toast.LENGTH_LONG).show();
    }*/
    public void handleRegSubmitClick(View v){
        DatabaseConnect db = new DatabaseConnect();
        TextView userTelephone = findViewById(R.id.signup_phone);
        TextView userEmail = findViewById(R.id.singup_email);
        TextView userPassword = findViewById(R.id.signup_password);
        HashMap<String,String> userData = new HashMap<>();
        userData.put("user_telephone", userTelephone.getText().toString());
        userData.put("user_email", userEmail.getText().toString());
        userData.put("user_password", userPassword.getText().toString());
        MainActivity.user.telephone = userTelephone.getText().toString();
        MainActivity.user.email = userEmail.getText().toString();
        MainActivity.user.password = userPassword.getText().toString();
        db.InsertUser();
        while(DatabaseConnect.queryResult == 0){
          System.out.println("queryResult updating");
                    if(DatabaseConnect.queryResult == 1) startActivity(new Intent(this, ProfileSetUpActivity.class));
                    if(DatabaseConnect.queryResult == 2) startActivity(new Intent(this, ErrorActivity.class));
        }
    }

    public void SwitchToSignUp(View view) {
        startActivity(new Intent(this, SignUpActivity.class));
    }
}