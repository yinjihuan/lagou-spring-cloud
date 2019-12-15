package org.spring.cloud.multiple.demo.user.api.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {

	private int id;
	
	private String name;
	
}
