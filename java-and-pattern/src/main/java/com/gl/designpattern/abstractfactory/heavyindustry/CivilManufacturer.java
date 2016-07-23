package com.gl.designpattern.abstractfactory.heavyindustry;

public abstract class CivilManufacturer implements Manufacturer {

	@Override
	public Vehicle manufactureVehicle() {
		return new CivilTruck();
	}

	@Override
	public abstract Craft manufactureCraft();

	@Override
	public Ship manufactureShip() {
		return new CivilCruiseShip();
	}

}
