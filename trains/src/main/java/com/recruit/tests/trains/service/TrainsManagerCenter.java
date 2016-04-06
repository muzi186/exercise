package com.recruit.tests.trains.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static com.recruit.tests.trains.util.Constants.*;

import com.recruit.tests.trains.model.Route;
import com.recruit.tests.trains.model.Town;
import com.recruit.tests.trains.model.TrainsGragh;
import com.recruit.tests.trains.model.Trip;

public class TrainsManagerCenter {
    private TrainsGraghInitializer trainsGraghInitializer = new TrainsGraghInitializer();

    private TrainsGragh trainsGragh;

    public TrainsManagerCenter() {
        init(null);
    }

    public TrainsManagerCenter(InputStream trainsGragh) {
        init(trainsGragh);
    }

    private void init(InputStream is) {
        if (is == null) {
            is = TrainsManagerCenter.class.getClassLoader()
                    .getResourceAsStream(GRAGH_TXT_NAME);
        }

        if (is == null) {
            throw new RuntimeException(
                    "Cannot start trains manager center properly.");
        }

        try {
            trainsGragh = trainsGraghInitializer.createTrainsGragh(is);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                }
            }
        }

    }

    public int calculateRouteDistance(String... townNames) {
        if (townNames.length < 2) {
            return NO_SUCH_ROUTE;
        }
        
        int sumOfDistance = 0;

        String fromTownName = townNames[0];
        String toTownName = null;
        
        
        
        for(int i=1; i<townNames.length; i++){
            toTownName = townNames[i];
            
            Route availableRoute = trainsGragh.findRouteWithFromAndToTownName(fromTownName, toTownName);
            if(availableRoute == null){
                return NO_SUCH_ROUTE;
            }
            
            sumOfDistance+=availableRoute.getDistance();
            
            
            fromTownName = townNames[i];
        }

        return sumOfDistance;
    }
    
    public int calculateTripsWithMaxStops(String fromTownName, String toTownName, int maxStop){
        Town fromTown = trainsGragh.findTownWithName(fromTownName);
        Town toTown = trainsGragh.findTownWithName(toTownName);
        
        MaximumStopsTripGenerator gen = new MaximumStopsTripGenerator();
        gen.setMaxStops(maxStop);
        gen.setGragh(trainsGragh);
        gen.setStart(fromTown);
        gen.setEnd(toTown);
        
        List<Trip> calculatedTrips = gen.calculateTrips();
        return calculatedTrips.size();
    }
    
    public int calculateTripsWithexactStopAmount(String fromTownName, String toTownName, int exactStopAmount){
        ExactStopsTripGenerator gen = new ExactStopsTripGenerator();
        
        Town fromTown = trainsGragh.findTownWithName(fromTownName);
        Town toTown = trainsGragh.findTownWithName(toTownName);
        

        gen.setExactStops(exactStopAmount);
        gen.setGragh(trainsGragh);
        gen.setStart(fromTown);
        gen.setEnd(toTown);
        
        List<Trip> calculatedTrips = gen.calculateTrips();
        if(calculatedTrips.size() < 1){
            return NO_SUCH_ROUTE;
        }
        return calculatedTrips.size();
    }
    
    public int calculateShortestDistance(String fromTownName, String toTownName){
        ShortestDistanceTripGenerator gen = new ShortestDistanceTripGenerator();
        
        Town fromTown = trainsGragh.findTownWithName(fromTownName);
        Town toTown = trainsGragh.findTownWithName(toTownName);
        
        gen.setGragh(trainsGragh);
        gen.setStart(fromTown);
        gen.setEnd(toTown);
        
        List<Trip> calculatedTrips = gen.calculateTrips();
        
        if(calculatedTrips.size() < 1){
            return NO_SUCH_ROUTE;
        }
        
        
        return calculatedTrips.get(0).calculateDistance(trainsGragh);
    }
    
    public int calculateDifferentTripsWithDistanceThreshold(String fromTownName, String toTownName, int distanceThreshold){
        DistanceThresholdTripGenerator gen = new DistanceThresholdTripGenerator();
        
        Town fromTown = trainsGragh.findTownWithName(fromTownName);
        Town toTown = trainsGragh.findTownWithName(toTownName);
        
        gen.setGragh(trainsGragh);
        gen.setStart(fromTown);
        gen.setEnd(toTown);
        
        gen.setDistanceThreshold(distanceThreshold);
        
        List<Trip> calculatedTrips = gen.calculateTrips();
        
        if(calculatedTrips.size() < 1){
            return NO_SUCH_ROUTE;
        }
        
        return calculatedTrips.size();
    }
}
