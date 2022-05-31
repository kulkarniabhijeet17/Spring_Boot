package com.springboot.example3.models;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.hateoas.RepresentationModel;

@XmlRootElement(name = "user-report")
public class UserReport extends RepresentationModel<UserReport> implements Serializable {
	private static final long serialVersionUID = 1L;

	// You can add field as needed
}