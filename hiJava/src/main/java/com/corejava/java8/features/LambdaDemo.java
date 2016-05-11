package com.corejava.java8.features;

import java.util.Arrays;
import java.util.List;

public class LambdaDemo {
	public static void main(String...args){
		testRunnable();
	}
	
	public static void testRunnable(){
		List<String> names = Arrays.asList("aaa", "bbb", "ccc");
		Runnable r = () -> {
			for(String name:names){
				System.out.println(name);
			}
		};
		
		new Thread(r).start();
	}
}
