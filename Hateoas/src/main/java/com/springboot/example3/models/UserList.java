package com.springboot.example3.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.hateoas.RepresentationModel;

@XmlRootElement(name = "users")
public class UserList extends RepresentationModel<UserList> implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<UserInfo> users = new ArrayList<UserInfo>();

	public List<UserInfo> getUsers() {
		return users;
	}

	public void setUsers(List<UserInfo> users) {
		this.users = users;
	}
}