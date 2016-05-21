package com.corejava.datetime;

/**
 * Created by gavin on 16-5-21.
 */
public class SqlDateTimeDemo {

    public static void main(String...args){
        java.util.Date now = new java.util.Date();
        java.sql.Date date = new java.sql.Date(now.getTime());
        java.sql.Time time = new java.sql.Time(now.getTime());

        System.out.println("date:" + date.toString());
        System.out.println("time:"+ time.toString());
    }
}
