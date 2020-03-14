package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpringBootJSPController {
	@RequestMapping("/hello")
	public String index() {
		return "hello";
	}
}