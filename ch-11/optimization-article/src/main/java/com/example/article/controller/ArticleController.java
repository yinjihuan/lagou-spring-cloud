package com.example.article.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.article.client.UserRemoteClient;
import com.example.article.dto.Article;
import com.example.article.dto.User;

@RestController
public class ArticleController {

	@Autowired
	private UserRemoteClient userRemoteClient;
	
	private Logger logger = LoggerFactory.getLogger(ArticleController.class);
	
	@GetMapping("/article/get")
	public Article getUser(@RequestParam("id") int id) {
		logger.info("article/get");
		User user = userRemoteClient.getUser(id);
		return new Article(id, "java入门到放弃", user.getName());
	}
	
}
