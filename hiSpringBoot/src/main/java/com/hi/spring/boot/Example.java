package com.hi.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class Example {
	
	@RequestMapping("/{id}/home")
	String home(@PathVariable(value="id") String id,@RequestParam(value="name", defaultValue="Spring Boot") String name){
		String template = "Hello %s!\nAnd ID is %s";
		String result = String.format(template, name, id);
		return result;
	}

	public static void main(String[] args) {
		SpringApplication.run(Example.class, args);
	}

}
