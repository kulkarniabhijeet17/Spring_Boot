package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.util.User;

@Controller
public class SpringBootDBConnectivityController {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@RequestMapping("/")
	public String index(Model model) {
		List<User> userDetails = jdbcTemplate.query("select user_seq, user_id, first_name, last_name from userdetails",
				(rs, rowNum) -> {
					User user = new User();
					user.setUserSeq(rs.getInt("user_seq"));
					user.setUserId(rs.getString("user_id"));
					user.setFirstName(rs.getString("first_name"));
					user.setLastName(rs.getString("last_name"));

					return user;
				});
		model.addAttribute("userDetails", userDetails);
		if (userDetails != null) {
			for (User user : userDetails) {
				System.out.println("User ID is:: " + user.getUserId());
			}
		} else {
			System.out.println("List is blank");
		}
		return "user";
	}
}