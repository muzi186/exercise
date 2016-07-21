package com.gl.designpattern.decorator.invoice;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Order {
	private String customerName;
	private List<OrderLine> orderLines = new ArrayList<OrderLine>();
	private Date salesDate;

	public void printOrder(final OrderPrinter printer) {
		orderLines.forEach((o) -> {
			o.printLine(printer);
		});
	}

	public double getGrandTotal() {
		double amt = orderLines.stream().mapToDouble((e) -> {
			return e.getSubtotal();
		}).sum();
		return amt;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void addOrderLines(OrderLine orderLine) {
		this.orderLines.add(orderLine);
	}

	public Date getSalesDate() {
		return salesDate;
	}

	public void setSalesDate(Date salesDate) {
		this.salesDate = salesDate;
	}
	
	protected String formatCurrency(double amt){
		return NumberFormat.getCurrencyInstance().format(amt);
	}

}
