package com.springboot.example3.models;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.hateoas.RepresentationModel;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.NONE)
public class UserInfo extends RepresentationModel<UserInfo> implements Serializable {
	private static final long serialVersionUID = 1L;

	public UserInfo(Integer id, String firstName, String lastName, String email) {
		super();
		this.userId = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public UserInfo() {

	}

	@XmlAttribute
	private Integer userId;

	@XmlElement
	private String firstName;

	@XmlElement
	private String lastName;

	@XmlElement
	private String email;

	@Override
	public String toString() {
		return "UserInfo [id=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ "]";
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}