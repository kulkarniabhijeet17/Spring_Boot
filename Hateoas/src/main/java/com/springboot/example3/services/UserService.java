package com.springboot.example3.services;

import java.util.List;

import com.springboot.example3.models.UserInfo;

public interface UserService {
	List<UserInfo> getUserList();
}