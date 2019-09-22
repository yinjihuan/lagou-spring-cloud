package com.example.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.ribbon.dto.User;

@RestController
public class RibbonController {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/get")
	public Object get() {
		User user = restTemplate.getForEntity("http://user-service/user/get?id=1", User.class).getBody();
		//User user = restTemplate.getForEntity("http://localhost:8084/user/get?id=1", User.class).getBody();
		return user;
	}
	
}