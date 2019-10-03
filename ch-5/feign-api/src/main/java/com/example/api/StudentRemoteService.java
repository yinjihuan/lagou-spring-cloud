package com.example.api;

import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.api.request.StudentRequest;

public interface StudentRemoteService {

	@GetMapping("/student/name")
	public String getStudentName(@SpringQueryMap StudentRequest request);
	
}
