package com.cxytiandi.eureka_client.interceptor;

import java.io.IOException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import com.cxytiandi.auth.context.ContextHolder;

/**
 * RestTemplate拦截器，传递认证的Token
 * @author yinjihuan
 *
 */
@Component
public class TokenInterceptor implements ClientHttpRequestInterceptor {

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		System.err.println("进入RestTemplate拦截器");
		String uid = ContextHolder.getCurrentContext().get("uid");
		HttpHeaders headers = request.getHeaders();
	    headers.add("uid", uid);
	    return execution.execute(request, body);
	}

}
