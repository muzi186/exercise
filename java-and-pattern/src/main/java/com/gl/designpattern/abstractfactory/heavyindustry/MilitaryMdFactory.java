package com.gl.designpattern.abstractfactory.heavyindustry;

public class MilitaryMdFactory extends MilitaryManufacturer {

	@Override
	public Craft manufactureCraft() {
		return new MilitaryAirPlane();
	}

}
