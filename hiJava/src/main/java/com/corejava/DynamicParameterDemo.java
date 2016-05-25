package com.corejava;

/**
 * Created by gavin on 16-5-25.
 */
public class DynamicParameterDemo {



    public static void main(String...args){
        String value = System.getProperty("systemKey");

        System.out.println("value:"+value);
    }
}
