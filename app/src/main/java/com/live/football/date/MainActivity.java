package com.live.football.date;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {
    TextView date, UTC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        date = findViewById(R.id.date);
        UTC = findViewById(R.id.UTC);
        try {
            date.setText("IST Time is:" + new Date());
            UTC.setText("UTC Time is: " + getCurrentUtcTime());
            // print current time zone
//            System.out.println("IST Time is:" + new Date());
//            System.out.println("UTC Time is: " + getCurrentUtcTime());
        }
        // for handling parsing errors and exceptions
        catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static int getCurrentUtcTime() throws ParseException {  // handling ParseException
        // create an instance of the SimpleDateFormat class
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        // set UTC time zone by using SimpleDateFormat class
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+5"));
        //create another instance of the SimpleDateFormat class for local date format
        SimpleDateFormat ldf = new SimpleDateFormat("yyyyMMdd");
        // declare and initialize a date variable which we return to the main method
        Date d1 = null;
        String d21 = null;
        String d2 = "0";
        int d3 = 0;
        int month = 0;
        int date = 0;
        int year = 0;
        // use try catch block to parse date in UTC time zone
        try {
            // parsing date using SimpleDateFormat class
            d1 = ldf.parse(sdf.format(new Date()));
            d21 = sdf.format(new Date());
            String saal = d21.substring(0, 4);
            year = Integer.parseInt(saal);
            date = d1.getDate();
            month = d1.getMonth() + 1;
            d2 = year + "" + month + "" + date;
            d3 = Integer.parseInt(d2);
        }
        // catch block for handling ParseException
        catch (java.text.ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        // pass UTC date to main method.
        return d3;
    }
}