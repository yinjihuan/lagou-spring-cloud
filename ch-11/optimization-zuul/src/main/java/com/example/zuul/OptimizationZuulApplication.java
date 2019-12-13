package com.example.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class OptimizationZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(OptimizationZuulApplication.class, args);
	}

}
