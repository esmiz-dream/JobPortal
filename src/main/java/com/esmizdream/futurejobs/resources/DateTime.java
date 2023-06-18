/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esmizdream.futurejobs.resources;

import java.util.Calendar;
import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author hp
 */
public class DateTime {

    private static DateTime obj_datetime;
    private static Calendar calendar;
    private static Date sqlDate;
    private static Timestamp dateTime;

    private DateTime() {
    }

    public static DateTime getInstance() {
        if (obj_datetime == null) {
            obj_datetime = new DateTime();
        }
        return obj_datetime;
    }

    public static Date getSqlDate() {
        calendar = Calendar.getInstance();
        sqlDate = new Date(calendar.getTimeInMillis());
        return sqlDate;
    }

    public static Timestamp getSqlDateTime() {
        calendar = Calendar.getInstance();
        dateTime = new Timestamp(calendar.getTimeInMillis());
        return dateTime;
    }
}
