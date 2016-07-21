package com.gl.designpattern.decorator.invoice;

import java.io.PrintStream;

public class OrderPrinter {
	private PrintStream out;
	
	public OrderPrinter(){
		this(System.out);
	}
	
	public OrderPrinter(PrintStream out){
		if(out != null){
			this.out = out;
		}
	}
	
	public void println(String content){
		out.println(content);
	}
}
