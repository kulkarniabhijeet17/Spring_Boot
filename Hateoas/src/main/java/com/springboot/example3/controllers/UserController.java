package com.springboot.example3.controllers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.example3.models.UserInfo;
import com.springboot.example3.models.UserList;
import com.springboot.example3.models.UserReport;
import com.springboot.example3.services.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public UserList getAllUsers() {
		UserList userList = new UserList();

		for (UserInfo userInfo : userService.getUserList()) {
			// Adding self link user 'singular' resource
			Link link = linkTo(UserController.class).slash(userInfo.getUserId()).withSelfRel();

			// Add link to singular resource
			userInfo.add(link);

			// Adding method link user 'singular' resource
			ResponseEntity<UserReport> methodLinkBuilder = methodOn(UserController.class)
					.getReportByUserId(userInfo.getUserId());
			Link reportLink = linkTo(methodLinkBuilder).withRel("user-report");

			// Add link to singular resource
			userInfo.add(reportLink);

			userList.getUsers().add(userInfo);
		}

		// Adding self link user collection resource
		Link selfLink = linkTo(methodOn(UserController.class).getAllUsers()).withSelfRel();

		// Add link to collection resource
		userList.add(selfLink);

		return userList;
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<UserInfo> getUserById(@PathVariable("id") int id) {
		if (id <= 3) {
			UserInfo userInfo = userService.getUserList().get(id - 1);

			// Self link
			Link selfLink = linkTo(UserController.class).slash(userInfo.getUserId()).withSelfRel();

			// Method link
			Link reportLink = linkTo(methodOn(UserController.class).getReportByUserId(userInfo.getUserId()))
					.withRel("report");

			userInfo.add(selfLink);
			userInfo.add(reportLink);

			return new ResponseEntity<UserInfo>(userInfo, HttpStatus.OK);
		}

		return new ResponseEntity<UserInfo>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/users/{id}/report")
	public ResponseEntity<UserReport> getReportByUserId(@PathVariable("id") int id) {
		// Do some operation and return report
		return null;
	}
}