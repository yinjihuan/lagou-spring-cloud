package com.example.hystrix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.hystrix.dto.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
public class HystrixController {

	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(commandKey="getUser", groupKey="user", fallbackMethod = "fallback", threadPoolKey ="tpk1",
			commandProperties = {
					@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000") 
			}
	)
	@GetMapping("/get")
	public Object get() {
		System.err.println(Thread.currentThread().getName());
		User user = restTemplate.getForEntity("http://user-service/user/get?id=1", User.class).getBody();
		return user;
	}
	
	@HystrixCommand(commandKey="getUser2", groupKey="user",  fallbackMethod = "fallback", threadPoolKey ="tpk1",
			commandProperties = {
					@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "20000") 
			}
	)
	@GetMapping("/get2")
	public Object get2() {
		System.err.println(Thread.currentThread().getName());
		User user = restTemplate.getForEntity("http://user-service/user/get?id=1", User.class).getBody();
		return user;
	}
	
	@HystrixCommand(commandKey="getUser3", groupKey="user3",  fallbackMethod = "fallback", threadPoolKey ="tpk3",
			commandProperties = {
					@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "20000") 
			},
			threadPoolProperties = {
					@HystrixProperty(name = "queueSizeRejectionThreshold", value = "20") 
			}
	)
	@GetMapping("/get3")
	public Object get3() {
		System.err.println(Thread.currentThread().getName());
		User user = restTemplate.getForEntity("http://user-service/user/get?id=1", User.class).getBody();
		return user;
	}

	public Object fallback() {
		return new User(100, "默认");
	}

}