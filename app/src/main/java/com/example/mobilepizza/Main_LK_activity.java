package com.example.mobilepizza;

import androidx.appcompat.app.AppCompatActivity;
import androidx.transition.Visibility;

import android.graphics.BlendModeColorFilter;
import android.os.Bundle;
import android.widget.Button;

public class Main_LK_activity extends AppCompatActivity {

    private final String mainBtnColor = "#43AA72";
    private final String mainBtnColor_pressed = "#4A8E69";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lk);
        Button homeBtn = findViewById(R.id.lk_nav_home_btn);

    }
}