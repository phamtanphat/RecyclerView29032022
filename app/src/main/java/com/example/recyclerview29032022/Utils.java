package com.example.recyclerview29032022;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    public static Date createDateForHour(int hour) {
        Date date = new Date();
        date.setTime(hour * 360000);
        return date;
    }

    public static String formatHour(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        return simpleDateFormat.format(date);
    }
}
