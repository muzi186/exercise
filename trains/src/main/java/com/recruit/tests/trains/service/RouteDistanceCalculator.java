package com.recruit.tests.trains.service;

import com.recruit.tests.trains.model.Route;
import com.recruit.tests.trains.model.Town;
import com.recruit.tests.trains.model.TrainsGragh;
import com.recruit.tests.trains.model.Trip;
import com.recruit.tests.trains.util.Constants;

public class RouteDistanceCalculator {
    private TrainsGragh gragh;
    
    public RouteDistanceCalculator(TrainsGragh gragh){
        this.gragh = gragh;
    }

    public TrainsGragh getGragh() {
        return gragh;
    }

    public void setGragh(TrainsGragh gragh) {
        this.gragh = gragh;
    }
    
    public int calculateRouteDistance(Trip trip){
        int sumOfDistance = 0;
       
        Town fromTown = trip.getFromTown();
        
        for(Town stop:trip.getStops()){
            Route availableRoute = gragh.findRouteWithFromAndToTown(fromTown, stop);
            if(availableRoute == null){
                return Constants.NO_SUCH_ROUTE;
            }
            
            sumOfDistance+=availableRoute.getDistance();
            
            fromTown = stop;
        }
        
        return sumOfDistance;
    }
}
