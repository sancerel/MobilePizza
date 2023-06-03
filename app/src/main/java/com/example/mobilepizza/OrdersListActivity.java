package com.example.mobilepizza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.mobilepizza.Database.DatabaseConnect;
import com.example.mobilepizza.Order.Order;

import java.util.ArrayList;
import java.util.List;

public class OrdersListActivity extends AppCompatActivity {
    ArrayList<Order> ORDERS;

    //По нажатию на заказ в листе заказов и его подтверждения вызываем этот метод
    // в который передаем id заказа - он закрепится за курьером, если у него еще нет заказа
/*    public void setOrderForUser() throws Exception{
        if(MainActivity.user.hasOrder()) throw new Exception("Уже есть заказ");
        else{
            // Присвоить пользователю новый заказ: MainActivity.user.setOrder(new Order( данные которые получили из бд))

        }
    }*/
    public void executeOrders(){
        DatabaseConnect db = new DatabaseConnect();
        ORDERS = db.getOrders();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        executeOrders();
        setContentView(R.layout.activity_orders_list);
        setOrdersList();
    }
    private void setOrdersList(){
        LinearLayout sv_ll = findViewById(R.id.or_linear_layout);
        for (Order or : ORDERS) {
            String address = or.getAddres();
            String cost = or.getCost();
            TextView tv = new TextView(this);
            tv.setText(String.format("Заказ на сумму: %s. Адрес доставки %s.", cost, address));
            sv_ll.addView(tv);
        }
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