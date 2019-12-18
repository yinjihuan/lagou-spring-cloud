package org.spring.cloud.multiple.demo.user.provider.controller;

import org.spring.cloud.multiple.demo.common.base.Response;
import org.spring.cloud.multiple.demo.common.base.ResponseData;
import org.spring.cloud.multiple.demo.common.utils.JWTUtils;
import org.spring.cloud.multiple.demo.common.utils.JWTUtils.JWTResult;
import org.spring.cloud.multiple.demo.core.context.ContextHolder;
import org.spring.cloud.multiple.demo.user.api.UserAPI;
import org.spring.cloud.multiple.demo.user.api.request.UserLoginRequest;
import org.spring.cloud.multiple.demo.user.api.request.UserLogoutRequest;
import org.spring.cloud.multiple.demo.user.api.response.UserLoginResponse;
import org.spring.cloud.multiple.demo.user.api.response.UserResponse;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RestController;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CreateCache;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
public class UserRestController implements UserAPI {

	@CreateCache(name="logoutCache:", expire = 1000)
	private Cache<String, Long> logoutCache;
	
	@Override
	public ResponseData<UserLoginResponse> login(UserLoginRequest request) {
		if (!StringUtils.hasText(request.getUsername()) || !StringUtils.hasText(request.getPass()) ) {
			return Response.failByParams("参数不完整");
		}
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

	@Override
	public ResponseData<UserLoginResponse> logout(UserLogoutRequest request) {
		if (!StringUtils.hasText(request.getToken())) {
			return Response.failByParams("参数不完整");
		}
		String uid = ContextHolder.getCurrentContext().get("uid");
		log.info("user {}", uid);
		JWTResult jwtResult = JWTUtils.getInstance().checkToken(request.getToken());
		if (!jwtResult.getUid().equals(uid)) {
			return Response.failByParams("不能注销别人登陆信息");
		}
		logoutCache.put(request.getToken(), 1L);
		return Response.ok();
	}

}
