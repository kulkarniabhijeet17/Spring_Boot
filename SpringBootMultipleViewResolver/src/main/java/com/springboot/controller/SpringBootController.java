package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SpringBootController {
	@RequestMapping(value = { "/testJsp" }, method = RequestMethod.GET)
	public String testJspView() {
		return "testJsp";
	}

	@RequestMapping(value = { "/testThymeleaf" }, method = RequestMethod.GET)
	public String testThymeleafView() {
		return "th_page";
	}

	@RequestMapping(value = { "/testFreeMarker" }, method = RequestMethod.GET)
	public String testFreeMarkerView() {
		return "testFreeMarker";
	}
}