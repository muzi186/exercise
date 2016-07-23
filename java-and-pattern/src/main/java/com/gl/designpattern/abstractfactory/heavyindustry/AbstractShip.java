package com.gl.designpattern.abstractfactory.heavyindustry;

public abstract class AbstractShip implements Ship {

	@Override
	public void sail() {
		System.out.println(this.getClass().getSimpleName() + " sail...");
	}

	@Override
	public void anchor() {
		System.out.println(this.getClass().getSimpleName() + " anchor...");
	}

}
