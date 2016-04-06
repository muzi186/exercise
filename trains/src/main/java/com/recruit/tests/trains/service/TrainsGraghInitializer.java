package com.recruit.tests.trains.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.recruit.tests.trains.model.Route;
import com.recruit.tests.trains.model.Town;
import com.recruit.tests.trains.model.TrainsGragh;
import com.recruit.tests.trains.util.StringUtils;

public class TrainsGraghInitializer {
    public static final String INPUT_CONTENT_DELIMITER = ",";
    
    public TrainsGragh createTrainsGragh(InputStream is) {
        BufferedReader br = null;

        try {
            br = new BufferedReader(new InputStreamReader(is));

            StringBuilder sb = new StringBuilder(); 
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            
            String inputContent = StringUtils.omitWhitespaces(sb.toString());
            inputContent = inputContent.replaceAll("Graph:", "");
            if(StringUtils.isBlank(inputContent)){
                throw new RuntimeException(String.format("Bad input<%s>", inputContent));
            }
            
            
            
            return doCreateTrainsGragh(inputContent);
        } catch (IOException e) {
            throw new RuntimeException("Something wrong while initializing.", e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                }
            }
        }
    }
    
    
    private TrainsGragh doCreateTrainsGragh(String inputContent){
        TrainsGragh gragh = new TrainsGragh();
        
        String [] parts = inputContent.split(INPUT_CONTENT_DELIMITER);
        for(String part: parts){
            String fromTownName = part.substring(0, 1);
            String toTownName = part.substring(1, 2);
            int distance = Integer.valueOf(part.substring(2, part.length()));
            
            Town fromTown = gragh.findTownWithName(fromTownName);
            if(fromTown == null){
                fromTown = new Town(fromTownName);
                gragh.addTown(fromTown);
            }
            
            Town toTown = gragh.findTownWithName(toTownName);
            if(toTown == null){
                toTown = new Town(toTownName);
                gragh.addTown(toTown);
            }
            
            Route route  = new Route(fromTown, toTown, distance);
            
            List<Route> routesOfFromTown = gragh.findRoutesWithFromTown(fromTown);
            if(routesOfFromTown ==null){
                routesOfFromTown = new ArrayList<Route>();
                gragh.getRoutes().put(fromTown, routesOfFromTown);
            }
            
            routesOfFromTown.add(route);
            
        }
        
        return gragh;
    }
    
}
