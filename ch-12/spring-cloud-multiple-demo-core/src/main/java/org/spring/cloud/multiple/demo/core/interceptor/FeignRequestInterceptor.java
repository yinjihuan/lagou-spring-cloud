package org.spring.cloud.multiple.demo.core.interceptor;


import org.spring.cloud.multiple.demo.core.context.ContextHolder;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * Feign请求拦截器
 * 
 * @author yinjihuan
 *
 **/
public class FeignRequestInterceptor implements RequestInterceptor {
	
	public FeignRequestInterceptor() {
		
	}

	@Override
	public void apply(RequestTemplate template) {
		String uid = ContextHolder.getCurrentContext().get("uid");
		template.header("uid", uid);
	}
}