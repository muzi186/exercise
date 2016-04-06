package com.recruit.tests.trains.model;

import java.util.ArrayList;
import java.util.List;

import com.recruit.tests.trains.service.RouteDistanceCalculator;

public class Trip {
    private Town fromTown;
    private Town toTown;
    
    private List<Town> stops = new ArrayList<Town>();
    private Town currentStop;

    public Town getFromTown() {
        return fromTown;
    }

    public void setFromTown(Town fromTown) {
        this.fromTown = fromTown;
    }

    public Town getToTown() {
        return toTown;
    }

    public void setToTown(Town toTown) {
        this.toTown = toTown;
    }

    public List<Town> getStops() {
        return stops;
    }
    
    public int sizeOfStops(){
        return getStops().size();
    }

    public void addStop(Town stop) {
        getStops().add(stop);
    }
    
    public void addStops(List<Town> stops) {
        getStops().addAll(stops);
    }

    public Town getCurrentStop() {
        return currentStop;
    }

    public void setCurrentStop(Town currentStop) {
        this.currentStop = currentStop;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(fromTown.toString());
        for(Town t:stops){
            sb.append("-");
            sb.append(t.toString());
        }
        return sb.toString();
    }
    
    
    public int calculateDistance(TrainsGragh gragh){
        return new RouteDistanceCalculator(gragh).calculateRouteDistance(this);
    }
}
