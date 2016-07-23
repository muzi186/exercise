package com.gl.designpattern.abstractfactory.heavyindustry;

public class CivilBoeingFactory extends CivilManufacturer {

	@Override
	public Craft manufactureCraft() {
		return new CivilAirPlane();
	}

}
