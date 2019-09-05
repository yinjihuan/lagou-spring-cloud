package com.example.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@Autowired
	private CustomHealthIndicator customHealthIndicator;
	
	@GetMapping("/updateStatus")
	public String updateStatus(boolean status) {
		customHealthIndicator.setStatus(status);
		return "success";
	}
	
}
