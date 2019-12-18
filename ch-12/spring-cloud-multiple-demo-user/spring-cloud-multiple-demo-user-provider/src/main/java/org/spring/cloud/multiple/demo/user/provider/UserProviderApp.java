package org.spring.cloud.multiple.demo.user.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;

@ComponentScan(basePackages={"org.spring.cloud.multiple.demo"})
@EnableCreateCacheAnnotation
@SpringBootApplication
public class UserProviderApp {
	public static void main(String[] args) {
		SpringApplication.run(UserProviderApp.class, args);
	}
}
