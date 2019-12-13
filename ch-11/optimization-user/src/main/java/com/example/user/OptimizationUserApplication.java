package com.example.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableHystrix
@SpringBootApplication
public class OptimizationUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(OptimizationUserApplication.class, args);
	}

}
