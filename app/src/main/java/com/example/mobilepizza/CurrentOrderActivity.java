package com.example.mobilepizza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.wifi.hotspot2.pps.HomeSp;
import android.os.Bundle;
import android.view.View;

import com.yandex.mapkit.Animation;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.mapview.MapView;

public class CurrentOrderActivity extends AppCompatActivity {
    private final Point TARGET_LOCATION = new Point(56.844251, 60.653960);
    private MapView mapView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MapKitFactory.initialize(this);

        setContentView(R.layout.activity_current_order);
        mapView = (MapView)findViewById(R.id.mapview);
        mapView.getMap().move(
                new CameraPosition(TARGET_LOCATION, 11.0f, 0.0f, 0.0f),
                new Animation(Animation.Type.SMOOTH, 0),
                null);
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