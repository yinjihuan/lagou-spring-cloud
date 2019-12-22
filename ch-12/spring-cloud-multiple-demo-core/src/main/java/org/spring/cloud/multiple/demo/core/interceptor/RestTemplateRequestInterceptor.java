package org.spring.cloud.multiple.demo.core.interceptor;

import java.io.IOException;

import org.spring.cloud.multiple.demo.core.context.ContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

/**
 * RestTemplate拦截器，传递认证的Token
 * @author yinjihuan
 *
 */
public class RestTemplateRequestInterceptor implements ClientHttpRequestInterceptor {

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		String uid = ContextHolder.getCurrentContext().get("uid");
		HttpHeaders headers = request.getHeaders();
	    headers.add("uid", uid);
	    return execution.execute(request, body);
	}

}
