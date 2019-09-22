package com.example.ribbon.rule;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.Server;

public class MyIPing implements IPing {

	@Override
	public boolean isAlive(Server server) {
 		return true;
	}

}
