package com.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringBootController {
	@RequestMapping("/hello")
	public String index() {
		System.out.println("Greetings from Spring Boot!");
		return "Greetings from Spring Boot!";
	}
}