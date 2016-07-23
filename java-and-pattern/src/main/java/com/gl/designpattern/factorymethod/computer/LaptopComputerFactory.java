package com.gl.designpattern.factorymethod.computer;

public class LaptopComputerFactory implements ComputerFactory {

	@Override
	public Computer make() {
		return new LaptopComputer();
	}

}
