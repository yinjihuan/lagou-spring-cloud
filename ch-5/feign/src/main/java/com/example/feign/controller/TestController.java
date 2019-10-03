package com.example.feign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.request.StudentRequest;
import com.example.feign.client.StudentRemoteClient;
import com.example.feign.client.UserRemoteClient;
import com.example.feign.dto.User;

@RestController
public class TestController {

	@Autowired
	private UserRemoteClient userRemoteClient;
	
	@Autowired
	private StudentRemoteClient studentRemoteClient;
	
	@GetMapping("/getUser")
	public User getUser() {
		return userRemoteClient.getUser(1);
	}
	
	@GetMapping("/getStudent")
	public String getStudent() {
		StudentRequest request = new StudentRequest();
		request.setName("yinjihuan");
		request.setAge(18);
		return studentRemoteClient.getStudentName(request);
	}
	
}
