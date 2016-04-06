package com.recruit.tests.trains.service;

import java.io.InputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import com.recruit.tests.trains.model.Town;
import com.recruit.tests.trains.model.TrainsGragh;
import com.recruit.tests.trains.model.Trip;

public class RouteDistanceCalculatorTest {
    static final String GRAGH_TXT_NAME = "gragh-for-unit-test.txt";
    InputStream is;
    TrainsGraghInitializer trainsGraghInitializer;
    TrainsGragh gragh;
    RouteDistanceCalculator cal;

    @Before
    public void setUp() throws Exception {
        trainsGraghInitializer = new TrainsGraghInitializer();
        is = TrainsGraghInitializerTest.class.getClassLoader()
                .getResourceAsStream(GRAGH_TXT_NAME);
        gragh = trainsGraghInitializer.createTrainsGragh(is);
        
        cal = new RouteDistanceCalculator(gragh);
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
    public void testCalculateRouteDistance() {
        final int expectedDistance = 9;
        
        Town a = gragh.findTownWithName("A");
        Town b = gragh.findTownWithName("B");
        Town c = gragh.findTownWithName("C");
        
        Trip trip = new Trip();
        trip.setFromTown(a);
        trip.setToTown(c);
        trip.addStop(b);
        trip.addStop(c);
        
        int distance = cal.calculateRouteDistance(trip);
        
        assertEquals("verify the distance of trip.", expectedDistance, distance);
    }

}
