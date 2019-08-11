package com.example.user;

import org.springframework.boot.context.properties.ConfigurationProperties;
import lombok.Data;

@Data
@ConfigurationProperties("spring.user")
public class UserPorperties {

	private String name;
	
}
