package com.example.mobilepizza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.mobilepizza.Database.DatabaseConnect;
import com.example.mobilepizza.Order.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class OrdersListActivity extends AppCompatActivity {
    HashMap<LinearLayout,UUID> ORDERMAP = new HashMap<LinearLayout,UUID>();
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
            UUID orderId = or.getOrderId();

            TextView tv = new TextView(this);
            Button btn = new Button(this);
            LinearLayout ll = new LinearLayout(this);

            tv.setText(String.format("Заказ на сумму: %s. \n Адрес доставки %s.", cost, address));
            //tv.setMaxWidth(250);
            tv.setPadding(50,30,50,30);
            btn.setText("Принять заказ");
            btn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    acceptOrder(btn.getParent());
                    btn.setEnabled(false);
                    btn.setText("Принят");
                }
            });
            ll.setOrientation(LinearLayout.HORIZONTAL);
            ll.addView(tv);
            ll.addView(btn);
            ORDERMAP.put(ll,orderId);
            sv_ll.addView(ll);
        }
    }

    public void acceptOrder(ViewParent parent){
        DatabaseConnect db = new DatabaseConnect();
        UUID orderid = ORDERMAP.get(parent);
        db.getOrdersId(orderid);
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