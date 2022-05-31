package com.springboot.example3.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.example3.models.UserInfo;
import com.springboot.example3.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	public List<UserInfo> getUserList() {
		List<UserInfo> list = new ArrayList<>();

		UserInfo user1 = new UserInfo(1, "Lokesh", "Gupta", "howtodoinjava@gmail.com");
		UserInfo user2 = new UserInfo(2, "Amit", "Singhal", "asinghal@yahoo.com");
		UserInfo user3 = new UserInfo(3, "Kirti", "Mishra", "kmishra@gmail.com");

		list.add(user1);
		list.add(user2);
		list.add(user3);

		return list;
	}
}