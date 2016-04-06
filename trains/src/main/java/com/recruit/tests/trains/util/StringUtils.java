package com.recruit.tests.trains.util;

public final class StringUtils {
    private StringUtils(){}
    
    public static boolean isBlank(String s){
        return ((s==null) || (s.trim().length() < 1));
    }
    
    public static boolean isNotBlank(String s){
        return !isBlank(s);
    }
    
    public static String omitWhitespaces(String s){
        if(s==null){
            return null;
        }
        return s.replaceAll(" ", "");
    }
}
