package com.gl.designpattern.abstractfactory.heavyindustry;

public abstract class AbstractVehicle implements Vehicle {

	@Override
	public void drive() {
		System.out.println(this.getClass().getSimpleName() + " drive");

	}

	@Override
	public void reverse() {
		System.out.println(this.getClass().getSimpleName() + "reverse");

	}

	@Override
	public void parking() {
		System.out.println(this.getClass().getSimpleName() + " parking");

	}

	@Override
	public void none() {
		System.out.println(this.getClass().getSimpleName() + " none");

	}

}
