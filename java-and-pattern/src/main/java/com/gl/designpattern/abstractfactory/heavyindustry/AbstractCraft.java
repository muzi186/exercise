package com.gl.designpattern.abstractfactory.heavyindustry;

public abstract class AbstractCraft implements Craft {

	@Override
	public void takeoff() {
		System.out.println(this.getClass().getSimpleName() + " takeoff...");
	}

	@Override
	public void land() {
		System.out.println(this.getClass().getSimpleName() + " land...");

	}

	@Override
	public void fly() {
		System.out.println(this.getClass().getSimpleName() + " flying...");
	}

}
