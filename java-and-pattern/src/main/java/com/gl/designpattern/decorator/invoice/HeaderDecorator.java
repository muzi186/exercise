package com.gl.designpattern.decorator.invoice;

public class HeaderDecorator extends OrderDecorator {

	public HeaderDecorator(Order order) {
		super(order);
	}
	
	
	
	@Override
	public void printOrder(OrderPrinter printer) {
		printHeader(printer);
		super.printOrder(printer);
	}



	private void printHeader(OrderPrinter printer){
		printer.println("\t***\tINVOICE\t***");
		printer.println("XYZ在线商城");
		printer.println(String.format("Date of Sale:%s", this.getOrder().getSalesDate()));
		printer.println("================================================");
		printer.println("Item\tUnits\tUnit Price\tSubtotal");
	}

}
