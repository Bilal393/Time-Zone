package com.live.football.date;


import android.content.Context;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class MainActivity {


    public static int getCurrentDate(Context context) throws ParseException {  // handling ParseException
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+5"));
        SimpleDateFormat ldf = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");

        // declare and initialize a date variable which we return to the main method
        Date date = null;
        String date2 = null;
        int CurrentDate = 0;
        String month = "0";
        String day = "0";
        int year = 0;
        String time = "0";
        // use try catch block to parse date in UTC time zone
        try {
            // parsing date using SimpleDateFormat class
            date = ldf.parse(sdf.format(new Date()));
            date2 = sdf.format(new Date());
            String saal = date2.substring(0, 4);
            year = Integer.parseInt(saal);
            month = date.getMonth() + 1 + "";
            if (date.getMonth() + 1 < 10)
                month = "0" + (date.getMonth() + 1);
            day = date.getDate() + "";
            if (date.getDate() < 10)
                day = "0" + (date.getDate());
            CurrentDate = Integer.parseInt(year + "" + month + "" + day);

        }
        // catch block for handling ParseException
        catch (java.text.ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            Toast.makeText(context, "Error to get Current Date", Toast.LENGTH_SHORT).show();
        }
        // pass UTC date to main method.
        return CurrentDate;
    }

    public static String getTime(Context context) throws ParseException {
        Date date = null;
        String time = "0";
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");
            sdf.setTimeZone(TimeZone.getTimeZone("GMT+5"));
            SimpleDateFormat ldf = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");
            String hour = "0";
            String min = "0";
            date = ldf.parse(sdf.format(new Date()));
            hour = date.getHours() + "";
            if (date.getHours()<10){
                hour = "0" + (date.getHours());
            }
            min = date.getMinutes() + "";
            if (date.getMinutes()<10){
                min = "0" + (date.getMinutes());
            }
            time = hour + "" + min;
        } catch (Exception e) {
            Toast.makeText(context, "Error to get Time", Toast.LENGTH_SHORT).show();
        }

        return time;
    }
}