package com.example.mobilepizza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class OrdersListActivity extends AppCompatActivity {

    //По нажатию на заказ в листе заказов и его подтверждения вызываем этот метод
    // в который передаем id заказа - он закрепится за курьером, если у него еще нет заказа
    public void setOrderForUser() throws Exception{
        if(MainActivity.user.hasOrder()) throw new Exception("Уже есть заказ");
        else{
            // Присвоить пользователю новый заказ: MainActivity.user.setOrder(new Order( данные которые получили из бд))

        }
    }






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