package org.spring.cloud.multiple.demo.core.config;

import java.util.ArrayList;
import java.util.List;
import org.spring.cloud.multiple.demo.core.filter.HttpHeaderParamFilter;
import org.spring.cloud.multiple.demo.core.interceptor.FeignRequestInterceptor;
import org.spring.cloud.multiple.demo.core.interceptor.RestTemplateRequestInterceptor;
import org.spring.cloud.multiple.demo.core.strategy.AuthHystrixConcurrencyStrategy;
import org.spring.cloud.multiple.demo.core.strategy.ZuulHystrixConcurrencyStrategy;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

	@Bean
	@ConditionalOnProperty("user.info.enabled")
	public FilterRegistrationBean<HttpHeaderParamFilter> filterRegistrationBean() {
		FilterRegistrationBean<HttpHeaderParamFilter> registrationBean = new FilterRegistrationBean<HttpHeaderParamFilter>();
		HttpHeaderParamFilter httpHeaderParamFilter = new HttpHeaderParamFilter();
		registrationBean.setFilter(httpHeaderParamFilter);
		List<String> urlPatterns = new ArrayList<String>(1);
		urlPatterns.add("/*");
		registrationBean.setUrlPatterns(urlPatterns);
		return registrationBean;
	}
	
	@Bean
	@ConditionalOnProperty("auth.hystrixConcurrencyStrategy.enabled")
	public AuthHystrixConcurrencyStrategy authHystrixConcurrencyStrategy() {
		return new AuthHystrixConcurrencyStrategy();
	}
	
	@Bean
	@ConditionalOnProperty("zuul.hystrixConcurrencyStrategy.enabled")
	public ZuulHystrixConcurrencyStrategy zuulHystrixConcurrencyStrategy() {
		return new ZuulHystrixConcurrencyStrategy();
	}
	
	@Bean
	@ConditionalOnProperty("feign.requestInterceptor.enabled")
	public FeignRequestInterceptor feignRequestInterceptor() {
		return new FeignRequestInterceptor();
	}
	
	@Bean
	@ConditionalOnProperty("restTemplate.requestInterceptor.enabled")
	public RestTemplateRequestInterceptor restTemplateRequestInterceptor() {
		return new RestTemplateRequestInterceptor();
	}

}
