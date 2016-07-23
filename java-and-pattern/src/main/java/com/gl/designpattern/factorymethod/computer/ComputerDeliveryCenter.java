package com.gl.designpattern.factorymethod.computer;

public class ComputerDeliveryCenter {
	
	
	public void deliver(String customerName, Computer c){
		System.out.printf("deliver %s to customer <%s>.\n", c.getClass().getSimpleName(), customerName);
	}

	public static void main(String[] args) {
		String customer1 = "Jim Green";
		String customer2 = "David Wang";
		String customer3 = "Tom Ma";
		
		Computer computer1 = new LaptopComputerFactory().make();
		Computer computer2 = new DesktopComputerFactory().make();
		
		Computer computer3 = new AllInOneComputerFactory().make();
		
		ComputerDeliveryCenter delivery = new ComputerDeliveryCenter();
		delivery.deliver(customer1, computer1);
		delivery.deliver(customer2, computer2);
		delivery.deliver(customer3, computer3);

	}

}
