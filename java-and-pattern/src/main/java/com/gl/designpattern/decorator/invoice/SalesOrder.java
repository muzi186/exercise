package com.gl.designpattern.decorator.invoice;

public class SalesOrder extends Order {
	
	public void printOrder(OrderPrinter printer){
		super.printOrder(printer);
	}
}
