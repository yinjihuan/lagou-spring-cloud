package com.example.feign.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class CustomRequestInterceptor implements RequestInterceptor {

	@Override
	public void apply(RequestTemplate template) {
		System.err.println(template.url());
		template.header("myHeader", "xx.com");
	}

}
