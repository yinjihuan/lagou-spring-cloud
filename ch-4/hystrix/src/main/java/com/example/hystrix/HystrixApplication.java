package com.example.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

import com.example.hystrix.plugin.CustomHystrixEventNotifier;
import com.example.hystrix.plugin.CustomHystrixPropertiesStrategy;
import com.netflix.hystrix.strategy.HystrixPlugins;

@EnableHystrix
@SpringBootApplication
public class HystrixApplication {

	public static void main(String[] args) {
		// 手动注册插件
		//HystrixPlugins.getInstance().registerEventNotifier(new CustomHystrixEventNotifier());
		HystrixPlugins.getInstance().registerPropertiesStrategy(new CustomHystrixPropertiesStrategy());
		SpringApplication.run(HystrixApplication.class, args);
	}

}
