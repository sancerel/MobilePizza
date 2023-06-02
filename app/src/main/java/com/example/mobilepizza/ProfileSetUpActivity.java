package com.example.mobilepizza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.mobilepizza.Database.DatabaseConnect;

import java.util.HashMap;

public class ProfileSetUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_setup);

        // поменять кнопку
    }

    public void handleSetUpSubmitClick(View v){
        DatabaseConnect db = new DatabaseConnect();
        TextView userName = findViewById(R.id.setup_name);
        TextView userSurname = findViewById(R.id.setup_surname);
        TextView userFathername = findViewById(R.id.setup_father_name);
        String fullname = String.format("%s %s %s", userName.getText().toString(), userSurname.getText().toString(), userFathername.getText().toString());
        TextView date = findViewById(R.id.setup_date);
        HashMap<String,String> userData = new HashMap<>();
        userData.put("fullname", fullname);
        MainActivity.user.fullname = fullname;
        MainActivity.user.date = java.sql.Date.valueOf(date.getText().toString());
        db.upgradeToll();
        startActivity(new Intent(this, MainLKactivity.class));
    }
}