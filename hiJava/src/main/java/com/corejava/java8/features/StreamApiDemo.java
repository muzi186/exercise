package com.corejava.java8.features;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamApiDemo {

	public static void main(String[] args) {
		filterAndMapAndForeach();
		mapAndAnyMatch();

		intStream();
		sortAndFilterAndMap();

		supplier();

		collect();
		
		reduce();
	}

	public static void reduce() {
		System.out.println("-- reduce --");
		
		Supplier<Stream<Person>> supplier = () -> Stream.of(Person.builder(), Person.builder(), Person.builder(),
				Person.builder(), Person.builder());
		
		supplier.get().reduce((p1, p2) -> p1.getAge() > p2.getAge() ? p1:p2).ifPresent(System.out::println);;

	}

	public static void collect() {
		System.out.println("-- collect --");

		List<Person> initialPersons = Arrays.asList(Person.builder(), Person.builder(), Person.builder(),
				Person.builder(), Person.builder());

		Map<Integer, List<Person>> personsByAge = initialPersons.stream()
				.collect(Collectors.groupingBy(p -> p.getAge()));

		personsByAge.forEach((age, persons) -> System.out.format("Age:%d -- %s", age, persons));

	}

	public static void supplier() {
		System.out.println("-- supplier --");
		Supplier<Stream<String>> streamSupplier = () -> Stream.of("a1", "b1", "a2").filter(s -> s.startsWith("a"));

		streamSupplier.get().anyMatch(s -> true);
		streamSupplier.get().noneMatch(s -> true);
	}

	public static void sortAndFilterAndMap() {
		Stream.of("a1", "d1", "d2", "b1", "c", "b2").sorted((o1, o2) -> o1.compareTo(o2)).map(String::toUpperCase)
				.filter(s -> s.startsWith("B")).forEach(System.out::println);
	}

	public static void intStream() {
		// Obj1
		// Obj2
		// Obj3
		// Obj4
		IntStream.range(1, 5).mapToObj(i -> "Obj" + i).forEach(System.out::println);
		;
	}

	public static void filterAndMapAndForeach() {
		Arrays.asList("a1", "b1", "c1", "a2", "b2").stream().filter(s -> {
			System.out.println("filter:" + s);
			return s.startsWith("b");
		}).map(s -> {
			System.out.println("map:" + s);
			return s.toUpperCase();
		}).forEach(System.out::println);
	}

	public static void mapAndAnyMatch() {
		// map:a1
		// anyMatch:A1

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

class Person {
	private String oid;
	private String identity;
	private String name;
	private Integer age;
	private String description;

	public Person() {

	}

	public Person(String oid, String identity, String name, Integer age, String description) {
		super();
		this.oid = oid;
		this.identity = identity;
		this.name = name;
		this.age = age;
		this.description = description;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String toString() {
		return this.name;
	}

	public static Person builder() {
		String oid = UUID.randomUUID().toString();
		String identity = oid.substring(0, 10);
		String name = identity;
		Integer age = new Random().nextInt(100);
		String description = "Created from Builder";

		return new Person(oid, identity, name, age, description);

	}
}