package com.example.ribbon.config;

import org.springframework.context.annotation.Bean;

import com.example.ribbon.rule.MyRule;
import com.netflix.loadbalancer.IRule;

public class BeanConfiguration {

	@Bean
	public IRule myRule() {
		return new MyRule();
	}
	
}
