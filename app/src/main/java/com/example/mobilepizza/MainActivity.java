package com.example.mobilepizza;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;

import com.example.mobilepizza.ProgressBar.ProgressBarAnimation;

public class MainActivity extends AppCompatActivity {
    ProgressBar pb;
    Integer load_pb_time=5000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animatePb();
    }

    protected void animatePb(){
        pb = findViewById(R.id.progressBar);
        ProgressBarAnimation animation = new ProgressBarAnimation(pb,0f,100f);
        animation.setDuration(load_pb_time);
        pb.startAnimation(animation);
    }

}