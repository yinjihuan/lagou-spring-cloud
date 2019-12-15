package org.spring.cloud.multiple.demo.article.api.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ArticleResponse {

	private int id;
	
	private String title;
	
	private String author;
	
	private String content;
	
}
