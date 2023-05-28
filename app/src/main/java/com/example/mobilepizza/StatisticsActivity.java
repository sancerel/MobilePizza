package com.example.mobilepizza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class StatisticsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
    }

    public void SwitchToHome(View view) {
        startActivity(new Intent(this, MainLKactivity.class));
    }

    public void SwitchToCurrent(View view) {
        startActivity(new Intent(this, CurrentOrderActivity.class));
    }

    public void SwitchToList(View view) {
        startActivity(new Intent(this, OrdersListActivity.class));
    }
}