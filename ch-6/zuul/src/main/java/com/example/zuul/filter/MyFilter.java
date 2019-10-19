package com.example.zuul.filter;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class MyFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		System.err.println("MyFilter run ...");
		RequestContext context = RequestContext.getCurrentContext();
		// 请求拦截，不将该请求转发到后端服务
		//context.setSendZuulResponse(false);
		// 返回给客户端的数据
		//context.setResponseBody("hello");
		
		
		// 数据传递到后面的Filter
		context.set("shouldFilter", false);
		return null;
	}

	@Override
	public String filterType() {
		return FilterConstants.PRE_TYPE;
	}

	@Override
	public int filterOrder() {
		return 0;
	}

}
