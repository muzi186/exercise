package com.gl.designpattern.abstractfactory.heavyindustry;

public abstract class MilitaryShip extends AbstractShip implements Attackable {

	@Override
	public void attack() {
		System.out.println(this.getClass().getSimpleName() + " attack...");
	}

}
