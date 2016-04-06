package com.recruit.tests.trains.service;

import java.util.ArrayList;
import java.util.List;

import com.recruit.tests.trains.model.Route;
import com.recruit.tests.trains.model.Town;
import com.recruit.tests.trains.model.Trip;

public class ShortestDistanceTripGenerator extends TripGenerator {
    private int shortestDistance = Integer.MAX_VALUE;

    @Override
    protected void travel() {
        List<Trip> candidateTripsCopy = new ArrayList<Trip>(getCandidateTrips());

        for (Trip trip : candidateTripsCopy) {
            int tripDistance = trip.calculateDistance(getGragh());
            if (tripDistance > shortestDistance) {
                getCandidateTrips().remove(trip);
                continue;
            }

            if (trip.getCurrentStop().equals(getEnd()) && (tripDistance < shortestDistance)) {
                getChosenTrips().add(0,trip);
                shortestDistance = tripDistance;
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
