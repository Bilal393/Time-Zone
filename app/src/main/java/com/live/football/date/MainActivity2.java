package com.live.football.date;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;

public class MainActivity2 extends AppCompatActivity {
    TextView date;
    TextView time;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        date = findViewById(R.id.date);
        time = findViewById(R.id.time);
        try {
            int data = MainActivity.getCurrentDate(context);
            String ti = MainActivity.getTime(context);
            time.setText(ti);
            String to = String.valueOf(data);
            date.setText(to);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}