package com.recruit.tests.trains.service;

import java.util.ArrayList;
import java.util.List;

import com.recruit.tests.trains.model.Route;
import com.recruit.tests.trains.model.Town;
import com.recruit.tests.trains.model.Trip;

public class ExactStopsTripGenerator extends TripGenerator {
    
    private int exactStops;
    
    public int getExactStops() {
        return exactStops;
    }

    public void setExactStops(int exactStops) {
        this.exactStops = exactStops;
    }

    @Override
    protected void travel() {
        List<Trip> candidateTripsCopy = new ArrayList<Trip>(getCandidateTrips());

        for (Trip trip : candidateTripsCopy) {
            if (trip.sizeOfStops() > exactStops) {
                getCandidateTrips().remove(trip);
                continue;
            }

            if (trip.getCurrentStop().equals(getEnd()) && (trip.sizeOfStops() == exactStops)) {
                getChosenTrips().add(trip);
            }

            Town currentStop = trip.getCurrentStop();
            List<Route> routesOfCurrentStop = getGragh()
                    .findRoutesWithFromTown(currentStop);
            if ((routesOfCurrentStop != null)
                    && (routesOfCurrentStop.size() > 0)) {
                for (Route route : routesOfCurrentStop) {
                    Trip travelledTrip = new Trip();
                    travelledTrip.setFromTown(trip.getFromTown());
                    travelledTrip.setToTown(trip.getToTown());
                    travelledTrip.setCurrentStop(route.getTo());

                    travelledTrip.addStops(trip.getStops());
                    travelledTrip.addStop(route.getTo());

                    getCandidateTrips().add(travelledTrip);
                }
            }

            getCandidateTrips().remove(trip);
        }
    }

}
