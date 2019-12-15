package org.spring.cloud.multiple.demo.article.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages="org.spring.cloud.multiple.demo.user.api")
@SpringBootApplication
public class ArticleProviderApp {
	public static void main(String[] args) {
		SpringApplication.run(ArticleProviderApp.class, args);
	}
}
