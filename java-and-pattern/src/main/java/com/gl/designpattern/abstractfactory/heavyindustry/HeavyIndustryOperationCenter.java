package com.gl.designpattern.abstractfactory.heavyindustry;

public class HeavyIndustryOperationCenter {

	public static void main(String[] args) {
		Manufacturer militaryBoeingFactory = new MilitaryBoeingFactory();
		Manufacturer militaryMdFactory = new MilitaryMdFactory();
		
		Manufacturer civilBoeingFactory = new CivilBoeingFactory();
		Manufacturer civilMdFactory = new CivilMdFactory();
		
		Army chinaArmy = new Army();
		CivilCorporation internationalHeavyCorp = new CivilCorporation();
		
		chinaArmy.addCraft(militaryBoeingFactory.manufactureCraft());
		chinaArmy.addCraft(militaryMdFactory.manufactureCraft());
		
		chinaArmy.addShip(militaryBoeingFactory.manufactureShip());
		//chinaArmy.addShip(militaryMdFactory.manufactureShip());
		
		chinaArmy.addVehicle(militaryBoeingFactory.manufactureVehicle());
		//chinaArmy.addVehicle(militaryMdFactory.manufactureVehicle());
		
		internationalHeavyCorp.addCraft(civilBoeingFactory.manufactureCraft());
		internationalHeavyCorp.addShip(civilBoeingFactory.manufactureShip());
		internationalHeavyCorp.addVehicle(civilBoeingFactory.manufactureVehicle());
		internationalHeavyCorp.addVehicle(civilMdFactory.manufactureVehicle());
		
		chinaArmy.go();
		internationalHeavyCorp.go();
	}

}
