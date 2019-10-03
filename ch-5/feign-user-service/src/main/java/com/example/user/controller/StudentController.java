package com.example.user.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.api.StudentRemoteService;
import com.example.api.request.StudentRequest;

@RestController
public class StudentController implements StudentRemoteService {

	@Override
	public String getStudentName(StudentRequest request) {
		return request.getName();
	}
	
}
