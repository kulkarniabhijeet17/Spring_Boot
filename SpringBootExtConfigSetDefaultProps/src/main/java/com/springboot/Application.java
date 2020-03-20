package com.springboot;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		Map<String, Object> configProps = new HashMap<String, Object>();
		configProps.put("spring.config.location",
				"D:\\Abhijeet\\Computer Science\\workspace\\FrameWorks\\Spring\\Boot\\config.properties");
		SpringApplication app = new SpringApplication(Application.class);
		app.setDefaultProperties(configProps);
		app.run(args);
		// ApplicationContext context = app.run(args);
	}
}