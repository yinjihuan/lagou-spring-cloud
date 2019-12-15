package org.spring.cloud.multiple.demo.user.provider.controller;

import org.spring.cloud.multiple.demo.common.base.Response;
import org.spring.cloud.multiple.demo.common.base.ResponseData;
import org.spring.cloud.multiple.demo.common.utils.JWTUtils;
import org.spring.cloud.multiple.demo.user.api.UserAPI;
import org.spring.cloud.multiple.demo.user.api.request.UserLoginRequest;
import org.spring.cloud.multiple.demo.user.api.response.UserLoginResponse;
import org.spring.cloud.multiple.demo.user.api.response.UserResponse;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserRestController implements UserAPI {

	@Override
	public ResponseData<UserLoginResponse> login(UserLoginRequest request) {
		if (request.getUsername().equals("admin") && request.getPass().equals("admin")) {
			JWTUtils jwt = JWTUtils.getInstance();
			return Response.ok(UserLoginResponse.builder().token(jwt.getToken("1001")).build());
		}
		return Response.failByParams("认证失败");
	}

	@Override
	public ResponseData<UserResponse> getUser(int id) {
		return Response.ok(UserResponse.builder().id(1001).name("尹吉欢").build());
	}

}
