package com.example.article.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Article {

	private int id;
	
	private String title;
	
	private String username;
	
}
