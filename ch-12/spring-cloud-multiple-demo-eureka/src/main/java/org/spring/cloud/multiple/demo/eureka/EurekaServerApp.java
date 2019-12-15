package org.spring.cloud.multiple.demo.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Eureka 启动类
 * 
 * @author yinjihuan
 * 
 * @about http://cxytiandi.com/about
 *
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApp {
	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApp.class, args);
	}
}
