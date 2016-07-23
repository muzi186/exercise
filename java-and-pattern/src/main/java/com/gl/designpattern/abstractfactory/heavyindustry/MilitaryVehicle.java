package com.gl.designpattern.abstractfactory.heavyindustry;

public abstract class MilitaryVehicle extends AbstractVehicle implements Attackable {
	@Override
	public void attack() {
		System.out.println(this.getClass().getSimpleName() + " attack...");
	}
}
