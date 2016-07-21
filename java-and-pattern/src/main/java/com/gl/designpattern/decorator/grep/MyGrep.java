package com.gl.designpattern.decorator.grep;

import java.io.FileReader;
import java.io.IOException;

public class MyGrep {
	
	private static GrepView gv = new GrepView();

	public static void main(String[] args) {
		if(!checkAmountOfArgs(args)){
			printUsageAndExit();
		}
		
		String keyword = args[0];
		String filename = args[1];
		GrepReader g = null;
		try {
			g = new GrepReader(new FileReader(filename), keyword);
			gv.printResult(filename, g.readLines());
			
		} catch (IOException e) {
			gv.println(e.getMessage());
		}finally{
			if(g != null){
				try {
					g.close();
				} catch (IOException e) {
					gv.println(e.getMessage());
				}
			}
		}
	}
	
	private static boolean checkAmountOfArgs(String []args){
		if(args.length <= 1){
			return false;
		}
		
		if(args[0] == null || (args[0].trim().length() < 1)){
			return false;
		}
		
		if(args[1] == null || (args[1].trim().length() < 1)){
			return false;
		}
		
		return true;
	}
	
	private static void printUsageAndExit(){
		gv.println("Usage:java MyGrep keyword filetosearch");
		System.exit(1);
	}

}
