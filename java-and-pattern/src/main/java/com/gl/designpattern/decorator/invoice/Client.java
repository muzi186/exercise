package com.gl.designpattern.decorator.invoice;

import java.util.Date;

public class Client {

	public static void main(String[] args) {
		OrderPrinter printer = new OrderPrinter();
		
		Order order = new SalesOrder();
		order.setCustomerName("北头豪苑606");
		order.setSalesDate(new Date());
		
		OrderLine item1 = new OrderLine();
		item1.setItemName("洗衣液");
		item1.setUnitPrice(35.6);
		item1.setUnits(3);
		
		OrderLine item2 = new OrderLine();
		item2.setItemName("洗衣液");
		item2.setUnitPrice(35.6);
		item2.setUnits(5);
		
		OrderLine item3 = new OrderLine();
		item3.setItemName("洗衣液");
		item3.setUnitPrice(35.6);
		item3.setUnits(1);
		
		order.addOrderLines(item1);
		order.addOrderLines(item2);
		order.addOrderLines(item3);
		
		order = new HeaderDecorator(new FooterDecorator(order));
		
		order.printOrder(printer);
		
	}

}
