package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.UserClient;

@RestController
public class UserController {

	@Autowired
	private UserClient userClient;
	
	@GetMapping("/username")
	public String getUserName() {
		return userClient.getName();
	}
	
}
