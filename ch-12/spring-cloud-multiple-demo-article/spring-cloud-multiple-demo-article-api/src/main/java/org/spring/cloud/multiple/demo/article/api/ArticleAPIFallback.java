package org.spring.cloud.multiple.demo.article.api;

import org.spring.cloud.multiple.demo.article.api.response.ArticleResponse;
import org.spring.cloud.multiple.demo.common.base.Response;
import org.spring.cloud.multiple.demo.common.base.ResponseData;
import org.springframework.stereotype.Component;

@Component
public class ArticleAPIFallback implements ArticleAPI {

	@Override
	public ResponseData<ArticleResponse> getArticle(int id) {
		return Response.fail("熔断");
	}
	
}
