package com.recruit.tests.trains.service;

import static org.junit.Assert.assertEquals;
import static com.recruit.tests.trains.util.Constants.*;

import java.io.InputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TrainsManagerCenterTest {
    static final String GRAGH_TXT_NAME = "gragh-for-unit-test.txt";

    TrainsManagerCenter manager;
    InputStream is;

    @Before
    public void setUp() throws Exception {
        is = TrainsManagerCenterTest.class.getClassLoader()
                .getResourceAsStream(GRAGH_TXT_NAME);
        manager = new TrainsManagerCenter(is);
    }

    @After
    public void tearDown() throws Exception {
        if (is != null) {
            try {
                is.close();
            } catch (Exception e) {
            }
        }
    }

    @Test
    public void testCalculateRouteDistanceForABC() {
        int expectedDis = 9;
        int distance = manager.calculateRouteDistance("A", "B", "C");

        assertEquals("The distance of the route A-B-C", expectedDis, distance);
    }

    @Test
    public void testCalculateRouteDistanceForAD() {
        final int expectedDis = 5;
        int distance = manager.calculateRouteDistance("A", "D");
        assertEquals("The distance of the route A-D.", expectedDis, distance);
    }

    @Test
    public void testCalculateRouteDistanceForADC() {
        final int expectedDis = 13;
        int distance = manager.calculateRouteDistance("A", "D", "C");
        assertEquals("The distance of the route A-D-C", expectedDis, distance);
    }

    @Test
    public void testCalculateRouteDistanceForAEBCD() {
        final int expectedDis = 22;
        int distance = manager.calculateRouteDistance("A", "E", "B", "C", "D");
        assertEquals("The distance of the route A-E-B-C-D", expectedDis,
                distance);
    }

    @Test
    public void testCalculateRouteDistanceForAED() {
        final int expectedDis = NO_SUCH_ROUTE;
        int distance = manager.calculateRouteDistance("A", "E", "D");
        assertEquals("The distance of the route A-E-D", expectedDis, distance);
    }

    @Test
    public void testCalculateTripsWithMaxStopsForCC3() {
        final int expectedTrips = 2;
        final int maximumOfStops = 3;
        int trips = manager
                .calculateTripsWithMaxStops("C", "C", maximumOfStops);

        assertEquals(
                "The number of trips starting at C and ending at C with a maximum of 3 stops",
                expectedTrips, trips);
    }

    @Test
    public void testCalculateTripsWithExactStopAmountForAC4() {
        final int expectedTrips = 3;
        final int amountOfStops = 4;

        int trips = manager.calculateTripsWithexactStopAmount("A", "C",
                amountOfStops);

        assertEquals(
                "The number of trips starting at A and ending at C with exactly 4 stops",
                expectedTrips, trips);
    }

    @Test
    public void testCalculateShortestDistanceForAC() {
        final int expectedLength = 9;

        int length = manager.calculateShortestDistance("A", "C");

        assertEquals("The length of the shortest route (in terms of distance to travel) from A to C.", expectedLength, length);
    }

    @Test
    public void testCalculateShortestDistanceForBB() {
        final int expectedLength = 9;

        int length = manager.calculateShortestDistance("B", "B");

        assertEquals("The length of the shortest route (in terms of distance to travel) from B to B.", expectedLength, length);
    }
    
    @Test
    public void testCalculateDifferentTripsWithDistanceThresholdForCC30(){
        final int expectedNumberOfRoutes = 7;
        final int distanceThreshold = 30;
        
        int numberOfRoutes = manager.calculateDifferentTripsWithDistanceThreshold("C", "C", distanceThreshold);
        
        assertEquals("The number of different routes from C to C with a distance of less than 30.", expectedNumberOfRoutes, numberOfRoutes);
    }

}
