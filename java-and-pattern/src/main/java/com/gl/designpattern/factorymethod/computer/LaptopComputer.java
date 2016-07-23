package com.gl.designpattern.factorymethod.computer;

public class LaptopComputer implements Computer {

	@Override
	public void poweron() {
		System.out.println(this.getClass().getSimpleName() + " poweron...");

	}

	@Override
	public void shutdown() {
		System.out.println(this.getClass().getSimpleName() + " shutdown...");

	}

	@Override
	public void restart() {
		System.out.println(this.getClass().getSimpleName() + " restart...");

	}

}
