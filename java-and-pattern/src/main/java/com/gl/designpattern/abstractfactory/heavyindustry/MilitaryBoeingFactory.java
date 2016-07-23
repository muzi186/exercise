package com.gl.designpattern.abstractfactory.heavyindustry;

public class MilitaryBoeingFactory extends MilitaryManufacturer {

	@Override
	public Craft manufactureCraft() {
		return new MilitaryHelicopter();
	}

}
