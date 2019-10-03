package com.example.feign.config;

import org.springframework.context.annotation.Bean;

import com.example.feign.interceptor.CustomRequestInterceptor;

import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;

public class FeignConfiguration {

	@Bean
	public Logger.Level getLoggerLevel() {
		return Logger.Level.FULL;
	}

	@Bean
	public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
		return new BasicAuthRequestInterceptor("user", "password");
	}
	
	@Bean
	public CustomRequestInterceptor customRequestInterceptor() {
		return new CustomRequestInterceptor();
	}

	// Contract,feignDecoder,feignEncoder.....
}