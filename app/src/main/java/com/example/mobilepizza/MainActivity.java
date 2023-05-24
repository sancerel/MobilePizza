package com.example.mobilepizza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;

import com.example.mobilepizza.Database.DatabaseConnect;
import com.yandex.mapkit.MapKitFactory;


public class MainActivity extends AppCompatActivity {
    ProgressBar pb;
    public static User user;
    private final String MAPKIT_API_KEY = "6722f029-ef5d-429a-af61-ac3996909e71";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MapKitFactory.setApiKey(MAPKIT_API_KEY);
        setContentView(R.layout.activity_main);
        DatabaseConnect db = new DatabaseConnect();
        pb = findViewById(R.id.progressBar);
        user = new User();
        new MyTask().execute();
    }
    public void onButtonShowPopupWindowClick(View view) {

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.layouterror, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        // dismiss the popup window when touched
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });
    }

    protected void start(){
        startActivity(new Intent(this, RegistrationActivity.class));
    }

    public class MyTask extends AsyncTask<Void, Integer, Void>{
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                for (int i = 0; i <= 100; i++) {
                    Thread.sleep(2);
                    publishProgress(i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onProgressUpdate(Integer... values) {
            pb.setProgress(values[0]);
        }
        @Override
        protected void onPostExecute(Void result) {
            start();
        }
    }

}