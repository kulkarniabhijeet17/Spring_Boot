package com.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringBootController {
	@RequestMapping("/test")
	public String index() {
		return "<h1>Spring Boot App</h1>";
	}
}