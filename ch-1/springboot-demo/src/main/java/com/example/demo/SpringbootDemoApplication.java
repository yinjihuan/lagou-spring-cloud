package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.example.demo.filter.CustomFilter;
import com.example.user.EnableUserClient;

//@EnableUserClient
@SpringBootApplication
public class SpringbootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoApplication.class, args);
	}
	
	// 注册过滤器
	@Bean
	public FilterRegistrationBean<CustomFilter> registration() {
		CustomFilter filter = new CustomFilter();
		FilterRegistrationBean<CustomFilter> registration = new FilterRegistrationBean<CustomFilter>(filter);
		registration.addUrlPatterns("/*");
		return registration;
	}

}
