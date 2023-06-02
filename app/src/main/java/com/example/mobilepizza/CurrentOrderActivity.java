package com.example.mobilepizza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.wifi.hotspot2.pps.HomeSp;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.mobilepizza.Order.Order;
import com.yandex.mapkit.Animation;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.mapview.MapView;

public class CurrentOrderActivity extends AppCompatActivity {
    private final Point TARGET_LOCATION = new Point(56.844251, 60.653960);
    private MapView mapView;
    private Order CUR_ORDER;
    private Boolean HAS_ORDER;
    private User USER;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MapKitFactory.initialize(this);
        setContentView(R.layout.activity_current_order);
        USER = MainActivity.user;

        try{
            CUR_ORDER = USER.getOrder();
            HAS_ORDER = true;
        } catch (Exception e) {
            CUR_ORDER = null;
            HAS_ORDER = false;
        }
        InitLayoutFields();
        mapView = (MapView)findViewById(R.id.mapview);
        mapView.getMap().move(
                new CameraPosition(TARGET_LOCATION, 11.0f, 0.0f, 0.0f),
                new Animation(Animation.Type.SMOOTH, 0),
                null);
    }

    private void InitLayoutFields() {
        if(HAS_ORDER){
            TextView orderNameLayout = findViewById(R.id.order_name);
            TextView orderInfoLayout = findViewById(R.id.order_info);
            TextView orderCommsLayout = findViewById(R.id.order_comms);

            String cost = CUR_ORDER.getCost();
            String addres = CUR_ORDER.getAddres();

            orderNameLayout.setText(String.format("Заказ на стоимость %s ", cost));
            orderInfoLayout.setText(String.format("Адрес доставки: %s ", addres));
        }
    }

    @Override
    protected void onStop() {
        mapView.onStop();
        MapKitFactory.getInstance().onStop();
        super.onStop();
    }
    @Override
    protected void onStart() {
        super.onStart();
        MapKitFactory.getInstance().onStart();
        mapView.onStart();
    }
    public void SwitchToHome(View view) {
        startActivity(new Intent(this, MainLKactivity.class));
    }
    public void SwitchToList(View view) {
        startActivity(new Intent(this, OrdersListActivity.class));
    }
    public void SwitchToStat(View view) {
        startActivity(new Intent(this, StatisticsActivity.class));
    }
}