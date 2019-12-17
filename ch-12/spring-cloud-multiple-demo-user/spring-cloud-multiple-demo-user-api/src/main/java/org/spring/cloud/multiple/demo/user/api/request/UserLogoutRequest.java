package org.spring.cloud.multiple.demo.user.api.request;

import lombok.Data;

@Data
public class UserLogoutRequest {

	private String token;
	
}
