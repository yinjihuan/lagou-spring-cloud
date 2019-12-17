package org.spring.cloud.multiple.demo.user.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;

@EnableCreateCacheAnnotation
@SpringBootApplication
public class UserProviderApp {
	public static void main(String[] args) {
		SpringApplication.run(UserProviderApp.class, args);
	}
}
