package com.example.hystrix.plugin;

import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.strategy.properties.HystrixPropertiesCommandDefault;
import com.netflix.hystrix.strategy.properties.HystrixPropertiesStrategy;

/**
 * 自定义属性配置
 * @author yinjihuan
 *
 */
public class CustomHystrixPropertiesStrategy extends HystrixPropertiesStrategy {

	public HystrixCommandProperties getCommandProperties(HystrixCommandKey commandKey, HystrixCommandProperties.Setter builder) {
	    // 这里可以自己控制
		return new HystrixPropertiesCommandDefault(commandKey, builder);
	}
	
}
