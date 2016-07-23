package com.gl.designpattern.abstractfactory.heavyindustry;

import java.util.ArrayList;
import java.util.List;

public class Army implements Organization{
	private List<Craft> crafts = new ArrayList<Craft>();
	private List<Vehicle> vehicles = new ArrayList<Vehicle>();
	private List<Ship> ships = new ArrayList<Ship>();
	
	
	
	public void addCraft(Craft craft) {
		this.crafts.add(craft);
	}

	public void addVehicle(Vehicle vehicle) {
		this.vehicles.add(vehicle);
	}

	public void addShip(Ship ship) {
		this.ships.add(ship);
	}

	public void fly(){
		for(Craft c:crafts){
			c.fly();
		}
	}
	
	public void move(){
		for(Vehicle v:vehicles){
			v.drive();
		}
	}
	
	public void sail(){
		for(Ship s:ships){
			s.sail();
		}
	}

	@Override
	public void go() {
		fly();
		move();
		sail();
	}

}
