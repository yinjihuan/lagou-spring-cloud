package org.spring.cloud.multiple.demo.user.api;

import org.spring.cloud.multiple.demo.common.base.ResponseData;
import org.spring.cloud.multiple.demo.user.api.request.UserLoginRequest;
import org.spring.cloud.multiple.demo.user.api.request.UserLogoutRequest;
import org.spring.cloud.multiple.demo.user.api.response.UserLoginResponse;
import org.spring.cloud.multiple.demo.user.api.response.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="spring-cloud-multiple-demo-user-provider", fallback=UserAPIFallback.class)
public interface UserAPI {

	/**
	 * 登陆
	 * @param request
	 * @return
	 */
	@PostMapping("/login")
	ResponseData<UserLoginResponse> login(@RequestBody UserLoginRequest request);
	
	/**
	 * 登出
	 * @param request
	 * @return
	 */
	@PostMapping("/logout")
	ResponseData<UserLoginResponse> logout(@RequestBody UserLogoutRequest request);
	
	/**
	 * 获取用户
	 * @param id
	 * @return
	 */
	@GetMapping("/user/{id}")
	ResponseData<UserResponse> getUser(@PathVariable int id);
	
}
