package org.spring.cloud.multiple.demo.user.api;

import org.spring.cloud.multiple.demo.common.base.Response;
import org.spring.cloud.multiple.demo.common.base.ResponseData;
import org.spring.cloud.multiple.demo.user.api.request.UserLoginRequest;
import org.spring.cloud.multiple.demo.user.api.request.UserLogoutRequest;
import org.spring.cloud.multiple.demo.user.api.response.UserLoginResponse;
import org.spring.cloud.multiple.demo.user.api.response.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserAPIFallback implements UserAPI {

	@Override
	public ResponseData<UserLoginResponse> login(UserLoginRequest request) {
		return Response.fail("熔断");
	}

	@Override
	public ResponseData<UserResponse> getUser(int id) {
		return Response.fail("熔断");
	}

	@Override
	public ResponseData<UserLoginResponse> logout(UserLogoutRequest request) {
		return Response.fail("熔断");
	}
	
}
