package com.example.feign.client;

import org.springframework.stereotype.Component;

import com.example.feign.dto.User;

/**
 * 普通回退，没有异常信息
 * @author yinjihuan
 *
 */
@Component
public class UserRemoteClientFallback implements UserRemoteClient {

	@Override
	public User getUser(int id) {
		return new User(0, "默认fallback");
	}
	
}
