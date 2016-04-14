package com.j8.demo;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamApiDemo {

	public static void main(String[] args) {
		filterAndMapAndForeach();
		mapAndAnyMatch();

	}
	
	public static void filterAndMapAndForeach(){
		Arrays.asList("a1", "b1", "c1","a2", "b2").stream()
			.filter(s -> {
				System.out.println("filter:" + s);
				return s.startsWith("b");
			})
			.map(s-> {
				System.out.println("map:" + s);
				return s.toUpperCase();
			})
			.forEach(System.out::println);
	}

	public static void mapAndAnyMatch() {
		//map:a1
		//anyMatch:A1

		Stream.of("d2", "a1", "b2", "b1", "c", "a2", "e").map(s -> {
			System.out.println("map:" + s);
			return s.toUpperCase();
		}).anyMatch(s -> {
			System.out.println("anyMatch:" + s);
			return s.startsWith("A");
		}

		);
	}

}
