package com.gl.designpattern.factorymethod.computer;

public class AllInOneComputerFactory implements ComputerFactory {

	@Override
	public Computer make() {
		return new AllInOneComputer();
	}

}
