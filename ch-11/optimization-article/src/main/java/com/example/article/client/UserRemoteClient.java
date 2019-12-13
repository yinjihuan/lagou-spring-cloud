package com.example.article.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.article.dto.User;

@FeignClient(name = "optimization-user")
public interface UserRemoteClient {
	
	@GetMapping("/user/get")
	public User getUser(@RequestParam("id") int id);

}
