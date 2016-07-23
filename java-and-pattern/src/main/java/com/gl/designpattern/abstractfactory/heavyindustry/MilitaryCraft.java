package com.gl.designpattern.abstractfactory.heavyindustry;

public abstract class MilitaryCraft extends AbstractCraft implements Attackable {
	@Override
	public void attack() {
		System.out.println(this.getClass().getSimpleName() + " attack...");
	}
}
