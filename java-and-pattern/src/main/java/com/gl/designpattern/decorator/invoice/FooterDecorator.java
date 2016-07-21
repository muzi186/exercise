package com.gl.designpattern.decorator.invoice;

public class FooterDecorator extends OrderDecorator {

	public FooterDecorator(Order order) {
		super(order);
	}
		
	@Override
	public void printOrder(OrderPrinter printer) {
		
		super.printOrder(printer);
		printFooter(printer);
	}
	private void printFooter(OrderPrinter printer){
		printer.println("==========================================");
		printer.println(String.format("Total:\t\t\t%s", this.formatCurrency(this.getOrder().getGrandTotal())));
	}
}
