package com.cxytiandi.auth.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cxytiandi.auth.context.ContextHolder;

/**
 * 接收服务传递过来的用户信息
 * 
 * @author yinjihuan
 *
 */
public class HttpHeaderParamFilter implements Filter {
	public static ThreadLocal<Long> loginUserThreadLocal = new ThreadLocal<>();
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String uid = httpRequest.getHeader("uid");
		ContextHolder.getCurrentContext().add("uid", uid);
		chain.doFilter(httpRequest, httpResponse);
	}

	@Override
	public void destroy() {

	}
}