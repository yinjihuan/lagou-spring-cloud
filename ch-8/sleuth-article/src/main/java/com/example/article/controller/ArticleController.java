package com.example.article.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.article.dto.Article;
import com.example.article.dto.User;

@RestController
public class ArticleController {

	@Autowired
	private RestTemplate restTemplate;
	
	private Logger logger = LoggerFactory.getLogger(ArticleController.class);
	
	@GetMapping("/article/get")
	public Article getUser(@RequestParam("id") int id) {
		logger.info("article/get");
		ResponseEntity<User> userResp = restTemplate.getForEntity("http://sleuth-user/user/get?id=1", User.class);
		return new Article(id, "java入门到放弃", userResp.getBody().getName());
	}
	
}
