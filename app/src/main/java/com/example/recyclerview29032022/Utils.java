package com.example.recyclerview29032022;

public class Utils {

    public static long createTimeToMilliSeconds(int hour, int minus) {
        return (((hour * 3600) + (minus * 60)) * 1000);
    }

    public static int milliToHour(long time) {
        return (int) (time / 3600000);
    }

    public static int milliToMinus(long time) {
        return (int) ((time / 1000) % 60);
    }

    public static String formatTimeToString(long time) {
        int hour = milliToHour(time);
        int minus = milliToMinus(time);
        StringBuilder stringBuilder = new StringBuilder();
        if (hour < 10) {
            stringBuilder.append("0").append(hour);
        } else {
            stringBuilder.append(hour);
        }
        if (minus < 10) {
            stringBuilder.append(" : 0").append(minus);
        } else {
            stringBuilder.append(" : ").append(minus);
        }
        return stringBuilder.toString();
    }
}
