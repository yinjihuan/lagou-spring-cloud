package com.example.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.dto.User;

@RestController
public class UserController {

	@GetMapping("/user/get")
	public User getUser(int id) {
		return new User(id, "yinjihuan");
	}
	
}
