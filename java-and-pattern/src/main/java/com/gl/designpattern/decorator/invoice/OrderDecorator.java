package com.gl.designpattern.decorator.invoice;

public class OrderDecorator extends Order {
	private Order order;
	
	public OrderDecorator(Order order){
		this.order = order;
		this.setSalesDate(this.order.getSalesDate());
		this.setCustomerName(this.order.getCustomerName());
	}
	
	public void printOrder(OrderPrinter printer){
		getOrder().printOrder(printer);
	}
	
	protected Order getOrder(){
		return this.order;
	}
}
