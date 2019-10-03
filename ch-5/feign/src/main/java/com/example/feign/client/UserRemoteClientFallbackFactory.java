package com.example.feign.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.feign.dto.User;

import feign.hystrix.FallbackFactory;

/**
 * 有异常信息的回退
 * @author yinjihuan
 *
 */
@Component
public class UserRemoteClientFallbackFactory implements FallbackFactory<UserRemoteClient> {
	private Logger logger = LoggerFactory.getLogger(UserRemoteClientFallbackFactory.class);
	
	@Override
	public UserRemoteClient create(Throwable cause) {
		
		return new UserRemoteClient() {
			
			@Override
			public User getUser(int id) {
				logger.error("UserRemoteClient.getUser异常", cause);
				return new User(0, "默认");
			}
		};
	}
}
