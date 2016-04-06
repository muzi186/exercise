package com.recruit.tests.trains.service;

import java.io.InputStream;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.recruit.tests.trains.model.TrainsGragh;


public class TrainsGraghInitializerTest {
    static final String GRAGH_TXT_NAME = "gragh-for-unit-test.txt";
    InputStream is;
    TrainsGraghInitializer trainsGraghInitializer;

    @Before
    public void setUp() throws Exception {
        trainsGraghInitializer = new TrainsGraghInitializer();
        is = TrainsGraghInitializerTest.class.getClassLoader()
                .getResourceAsStream(GRAGH_TXT_NAME);
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
    public void testCreateTrainsGragh() {
        TrainsGragh gragh = trainsGraghInitializer.createTrainsGragh(is);
        
        assertNotNull(gragh);
        assertEquals("check amount of towns.", 5, gragh.getTowns().size());
        assertEquals("check amount of routes.",9, gragh.getAllRoutes().size());
    }

}
