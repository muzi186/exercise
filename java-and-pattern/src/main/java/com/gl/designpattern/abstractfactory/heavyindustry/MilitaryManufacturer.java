package com.gl.designpattern.abstractfactory.heavyindustry;

public abstract class MilitaryManufacturer implements Manufacturer {

	@Override
	public Vehicle manufactureVehicle() {
		return new MilitaryTank();
	}

	@Override
	public abstract Craft manufactureCraft();

	@Override
	public Ship manufactureShip() {
		return new MilitaryWarShip();
	}

}
