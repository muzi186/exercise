package com.recruit.tests.trains.service;

import java.util.ArrayList;
import java.util.List;

import com.recruit.tests.trains.model.Route;
import com.recruit.tests.trains.model.Town;
import com.recruit.tests.trains.model.TrainsGragh;
import com.recruit.tests.trains.model.Trip;

public abstract class TripGenerator {
    private Town start;
    private Town end;
    
    private TrainsGragh gragh;
    
    private List<Trip> candidateTrips = new ArrayList<Trip>();
    private List<Trip> chosenTrips = new ArrayList<Trip>();
    
    private int travelCounter = 0;

    public List<Trip> calculateTrips() {
        List<Route> routesOfStart = gragh.findRoutesWithFromTown(start);
        if( (routesOfStart != null) && (routesOfStart.size()>0)){
            for(Route route:routesOfStart){
                Trip tripCandidate = new Trip();
                tripCandidate.setFromTown(start);
                tripCandidate.setToTown(end);
                tripCandidate.setCurrentStop(route.getTo());
                
                tripCandidate.addStop(route.getTo());
                
                candidateTrips.add(tripCandidate);
            }
            
            while(candidateTrips.size() > 0){
                travel();
                travelCounter++;
            }
        }
        
        return chosenTrips;
    }
    
    protected abstract void travel();

    public Town getStart() {
        return start;
    }

    public void setStart(Town start) {
        this.start = start;
    }

    public Town getEnd() {
        return end;
    }

    public void setEnd(Town end) {
        this.end = end;
    }


    public TrainsGragh getGragh() {
        return gragh;
    }

    public void setGragh(TrainsGragh gragh) {
        this.gragh = gragh;
    }

    public int getTravelCounter() {
        return travelCounter;
    }

    public void setTravelCounter(int travelCounter) {
        this.travelCounter = travelCounter;
    }

    protected List<Trip> getCandidateTrips() {
        return candidateTrips;
    }

    protected List<Trip> getChosenTrips() {
        return chosenTrips;
    }
    
}
