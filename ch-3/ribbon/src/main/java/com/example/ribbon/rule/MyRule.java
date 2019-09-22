package com.example.ribbon.rule;

import java.util.List;
import java.util.Map;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.Server;

public class MyRule extends AbstractLoadBalancerRule {

	@Override
	public Server choose(Object key) {
		List<Server> upList = getLoadBalancer().getReachableServers();
		return upList.get(0);
	}

	@Override
	public void initWithNiwsConfig(IClientConfig clientConfig) {
		String clientName = clientConfig.getClientName();
		System.out.println(clientName);
	}

}
