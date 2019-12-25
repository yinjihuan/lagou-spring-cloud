package org.spring.cloud.multiple.demo.article.api;

import org.spring.cloud.multiple.demo.article.api.response.ArticleResponse;
import org.spring.cloud.multiple.demo.common.base.ResponseData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="spring-cloud-multiple-demo-article-provider", fallback=ArticleAPIFallback.class)
public interface ArticleAPI {

	/**
	 * 获取文章
	 * @param id
	 * @return
	 */
	@GetMapping("/article/{id}")
	ResponseData<ArticleResponse> getArticle(@PathVariable int id);
	
}
