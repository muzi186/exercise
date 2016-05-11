package com.hi.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class Example {
	
	@RequestMapping("/")
	String home(@RequestParam(value="name", defaultValue="Spring Boot") String name){
		String template = "Hello %s!";
		String result = String.format(template, name);
		return result;
	}

	public static void main(String[] args) {
		SpringApplication.run(Example.class, args);
	}

}
