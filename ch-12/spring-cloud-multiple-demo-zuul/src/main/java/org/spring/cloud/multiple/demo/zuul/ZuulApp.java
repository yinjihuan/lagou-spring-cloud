package org.spring.cloud.multiple.demo.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;

/**
 * Zuul 启动类
 * 
 * @author yinjihuan
 * 
 * @about http://cxytiandi.com/about
 *
 */
@ComponentScan(basePackages={"org.spring.cloud.multiple.demo"})
@EnableCreateCacheAnnotation
@EnableZuulProxy
@SpringBootApplication
public class ZuulApp {
	public static void main(String[] args) {
		SpringApplication.run(ZuulApp.class, args);
	}
}
