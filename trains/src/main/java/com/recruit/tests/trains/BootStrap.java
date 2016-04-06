package com.recruit.tests.trains;

import static com.recruit.tests.trains.util.Constants.NO_SUCH_ROUTE;
import static com.recruit.tests.trains.util.Constants.PARAM_GRAGH_TXT_FILE;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.recruit.tests.trains.service.TrainsManagerCenter;
import com.recruit.tests.trains.util.StringUtils;
public class BootStrap {

    public static void main(String[] args) {
        String graghfile = System.getProperty(PARAM_GRAGH_TXT_FILE);
        
        TrainsManagerCenter manager;
        
        if(StringUtils.isNotBlank(graghfile)){
            try {
                File f = new File(graghfile);
                InputStream is = new FileInputStream(f);
                manager = new TrainsManagerCenter(is);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }else{
            manager = new TrainsManagerCenter();
        }
        
        final int amountOfStops = 4;
        final int maximumOfStops = 3;
        final int distanceThreshold = 30;
        
        int result = manager.calculateRouteDistance("A", "B", "C");
        printResult(1, result);
        
        result = manager.calculateRouteDistance("A", "D");
        printResult(2, result);
        
        result = manager.calculateRouteDistance("A", "D", "C");
        printResult(3, result);
        
        result = manager.calculateRouteDistance("A", "E", "B", "C", "D");
        printResult(4, result);
        
        result = manager.calculateRouteDistance("A", "E", "D");
        printResult(5, result);
        
        result = manager
                .calculateTripsWithMaxStops("C", "C", maximumOfStops);
        printResult(6, result);
        
        result = manager.calculateTripsWithexactStopAmount("A", "C",
                amountOfStops);
        printResult(7, result);
        
        result = manager.calculateShortestDistance("A", "C");
        printResult(8, result);
        
        result = manager.calculateShortestDistance("B", "B");
        printResult(9, result);

        
        result = manager.calculateDifferentTripsWithDistanceThreshold("C", "C", distanceThreshold);
        printResult(10, result);
        
        
    }
    
    private static void printResult(int caseIdx, int result){
        String outputOfResult = (result == NO_SUCH_ROUTE? "NO SUCH ROUTE" : ("" + result));
        
        System.out.println(String.format("Output #%d: %s", caseIdx, outputOfResult));
    }

}
