package com.gl.designpattern.abstractfactory.heavyindustry;

public class CivilMdFactory extends CivilManufacturer {

	@Override
	public Craft manufactureCraft() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public Vehicle manufactureVehicle() {
		return new CivilCar();
	}

}
