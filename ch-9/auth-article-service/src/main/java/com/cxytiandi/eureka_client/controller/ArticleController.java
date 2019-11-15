package com.cxytiandi.eureka_client.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cxytiandi.auth.context.ContextHolder;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@RestController
public class ArticleController {

	private Logger logger = LoggerFactory.getLogger(ArticleController.class);
	
	@Autowired 	
	private RestTemplate restTemplate;  	
	
	//@HystrixCommand
	@GetMapping("/article/callHello") 	
	public String callHello(HttpServletRequest request) { 	
		// 正确获取方式：String uid = ContextHolder.getCurrentContext().get("uid");
		logger.info(Thread.currentThread().getName() + ":我是/article/callHello:"+request.getHeader("uid"));
	    return restTemplate.getForObject(
			"http://auth-user-service/user/hello", String.class); 	
	}
	
	
}
