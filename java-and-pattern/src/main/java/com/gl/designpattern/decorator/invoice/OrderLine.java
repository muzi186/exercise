package com.gl.designpattern.decorator.invoice;

import java.text.NumberFormat;

public class OrderLine {
	private String itemName;
	private int units;
	private double unitPrice;

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public void printLine(OrderPrinter printer){
		printer.println(String.format("%s\t%d\t%s\t%s", this.itemName, this.units,formatCurrency(unitPrice) ,formatCurrency(this.getSubtotal())));
	}

	public double getSubtotal() {
		return unitPrice * units;
	}

	private String formatCurrency(double amount) {
		return NumberFormat.getCurrencyInstance().format(amount);
	}
}
