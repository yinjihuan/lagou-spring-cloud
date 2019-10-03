package com.example.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import com.example.api.StudentRemoteService;

@FeignClient(value = "feign-user-service")
public interface StudentRemoteClient extends StudentRemoteService {

	
}