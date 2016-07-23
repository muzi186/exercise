package com.gl.designpattern.factorymethod.computer;

public class DesktopComputerFactory implements ComputerFactory {

	@Override
	public Computer make() {
		return new DesktopComputer();
	}

}
