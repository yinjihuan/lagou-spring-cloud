package com.example.consumer.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EurekaController {

	@Autowired
	private DiscoveryClient discoveryClient;
	
	/**
	 * 获取Eureka Server中所有服务实例信息
	 * @return
	 */
	@GetMapping("/instances")
	public List<ServiceInstance> getApplications() {
		List<ServiceInstance> instances = discoveryClient.getServices().stream()
			.map(sid -> discoveryClient.getInstances(sid))
			.collect(Collectors.toList())
			.stream().flatMap(list -> list.stream()).collect(Collectors.toList());
		return instances;
	}
	
}
