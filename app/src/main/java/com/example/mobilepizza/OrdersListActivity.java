package com.example.mobilepizza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class OrdersListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders_list);
    }

    public void SwitchToCurrent(View view) {
        startActivity(new Intent(this,CurrentOrderActivity.class));
    }


    public void SwitchToStat(View view) {
        startActivity(new Intent(this,StatisticsActivity.class));
    }

    public void SwitchToHome(View view) {
        startActivity(new Intent(this,MainLKactivity.class));
    }
}