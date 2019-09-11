package com.example.demo.actuate;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "springcloud")
public class SpringCloudEndPoint {
	
	@ReadOperation
	public Map<String, Object> showData() {
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("title", "springcloud");
		return data;
	}
	
}
