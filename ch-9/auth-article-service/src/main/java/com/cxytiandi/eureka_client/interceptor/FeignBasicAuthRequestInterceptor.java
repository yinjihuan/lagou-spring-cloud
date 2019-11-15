package com.cxytiandi.eureka_client.interceptor;

import com.cxytiandi.auth.context.ContextHolder;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * Feign请求拦截器
 * 
 * @author yinjihuan
 *
 **/
public class FeignBasicAuthRequestInterceptor implements RequestInterceptor {
	public FeignBasicAuthRequestInterceptor() {
		
	}

	@Override
	public void apply(RequestTemplate template) {
		String uid = ContextHolder.getCurrentContext().get("uid");
		template.header("uid", uid);
	}
}