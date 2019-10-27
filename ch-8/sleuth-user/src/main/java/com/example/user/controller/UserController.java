package com.example.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.dto.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import brave.ScopedSpan;
import brave.Tracer;

@RestController
public class UserController {
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	Tracer tracer;
	
	@HystrixCommand
	@GetMapping("/user/get")
	public User getUser(@RequestParam("id") int id) {
		logger.info("user/get");
		this.saveLog("1");
		return new User(id, "yinjihuan" + Thread.currentThread().getName());
	}
	
	  
	public void saveLog(String log) {
	    ScopedSpan span = tracer.startScopedSpan("saveLog");
	    try {
	      Thread.sleep(200);
	    } catch (Exception | Error e) {
	      span.error(e);
	    } finally {
	      span.finish(); 
	    }
	}

}
