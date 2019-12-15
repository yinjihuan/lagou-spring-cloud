package org.spring.cloud.multiple.demo.user.api.request;

import lombok.Data;

@Data
public class UserLoginRequest {

	private String username;
	
	private String pass;
	
}
