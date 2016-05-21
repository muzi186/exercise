package com.corejava;

/**
 * Created by gavin on 16-5-19.
 */
public class DoubleOperations {
    public static void main(String...args){
        long startTime = 33L;
        long endTime = 1000000L;

        double minutes = (endTime - startTime)*1.0/(1000*60);

        System.out.print(minutes);
    }
}
