package com.example.mobilepizza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.yandex.mapkit.MapKitFactory;

public class MainActivity extends AppCompatActivity {
    ProgressBar pb;
    private final String MAPKIT_API_KEY = "6722f029-ef5d-429a-af61-ac3996909e71";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MapKitFactory.setApiKey(MAPKIT_API_KEY);
        setContentView(R.layout.activity_main);


        pb = findViewById(R.id.progressBar);
        new MyTask().execute();
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