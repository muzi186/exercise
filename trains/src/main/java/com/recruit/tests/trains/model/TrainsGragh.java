package com.recruit.tests.trains.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrainsGragh {
    private List<Town> towns = new ArrayList<Town>();
    private Map<Town,List<Route>> routes = new HashMap<Town,List<Route>>();

    public List<Town> getTowns() {
        return towns;
    }
    
    public Map<Town,List<Route>> getRoutes(){
        return routes;
    }
    
    public List<Route> getAllRoutes(){
        List<Route> allRoutes = new ArrayList<Route>();
        
        for(Town key:routes.keySet()){
            allRoutes.addAll(routes.get(key));
        }
        
        return allRoutes;
    }
    
    public void addTown(Town town){
        if(town == null){
            throw new IllegalArgumentException("The town cannot be null here to add.");
        }
        
        for(Town t:getTowns()){
            if(town.getName().equalsIgnoreCase(t.getName())){
                return;
            }
        }
        
        getTowns().add(town);
    }
    
    public Town findTownWithName(String townName){
        for(Town t: getTowns()){
            if(t.getName().equalsIgnoreCase(townName)){
                return t;
            }
        }
        
        return null;
    }
    
    public List<Route> findRoutesWithFromTown(Town fromTown){
        return routes.get(fromTown);
    }
    
    public Route findRouteWithFromAndToTownName(String fromTownName, String toTownName){
        Town fromTown = findTownWithName(fromTownName);
        Town toTown = findTownWithName(toTownName);
        
        if( (fromTown == null) || (toTown == null)){
            return null;
        }
        
        return findRouteWithFromAndToTown(fromTown, toTown);
    }
    
    public Route findRouteWithFromAndToTown(Town fromTown, Town toTown){
        List<Route> routesOfFromTown = findRoutesWithFromTown(fromTown);
        
        if(routesOfFromTown == null){
            return null;
        }
        
        Route target = null;
        
        for(Route r : routesOfFromTown){
            if(r.getTo().equals(toTown)){
                target = r;
                break;
            }
        }
        
        return target;
    }
}
