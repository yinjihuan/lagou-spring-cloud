package org.spring.cloud.multiple.demo.user.api.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserLoginResponse {
	
	/**
	 * 登陆成功的Token
	 */
	private String token;
	
}
