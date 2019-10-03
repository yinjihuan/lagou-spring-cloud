package com.example.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.feign.config.FeignConfiguration;
import com.example.feign.dto.User;

@FeignClient(value = "feign-user-service", configuration = FeignConfiguration.class, /**fallback = UserRemoteClientFallback.class**/fallbackFactory = UserRemoteClientFallbackFactory.class)
public interface UserRemoteClient {
	
	@GetMapping("/user/get")
	public User getUser(@RequestParam("id")int id);
	
}