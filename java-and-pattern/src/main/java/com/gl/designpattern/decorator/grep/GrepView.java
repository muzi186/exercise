package com.gl.designpattern.decorator.grep;

import java.io.PrintStream;
import java.util.Map;

public class GrepView {
	private PrintStream out;
	
	public GrepView(){
		out = System.out;
	}
	
	public void println(String msg){
		out.println(msg);
	}
	
	public void printResult(String fileName, Map<Integer,String> lines){
		out.println(fileName);
		if(lines == null){
			return;
		}
		
		for(Integer lineNo:lines.keySet()){
			out.println(String.format("%d %s", lineNo, lines.get(lineNo)));
		}
	}
}
