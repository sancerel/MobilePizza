package com.example.mobilepizza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;

import com.example.mobilepizza.ProgressBar.ProgressBarAnimation;

public class MainActivity extends AppCompatActivity {
    ProgressBar pb;
    Integer load_pb_time=5000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pb = findViewById(R.id.progressBar);
        //animatePb();
        MyTask task = new MyTask();
        task.execute();
    }

    protected void animatePb(){
        ProgressBarAnimation animation = new ProgressBarAnimation(pb,0f,100f);
        animation.setDuration(load_pb_time);
        pb.startAnimation(animation);
    }
    protected void start(){
        startActivity(new Intent(this, RegistrationActivity.class));
    }

    public class MyTask extends AsyncTask<Void, Integer, Void>{
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                for (int i = 0; i <= 100; i++) {
                    Thread.sleep(50);
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