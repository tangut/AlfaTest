package com.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Small utils class for date logic, just for purpose of not adding it in services.
 * */
public class DateUtils {
    public static String getYesterdayDateString() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date yesterdayDate = getYesterday();
        return dateFormat.format(yesterdayDate);
    }

    private static Date getYesterday() {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }
}
