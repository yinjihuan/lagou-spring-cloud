package com.cxytiandi.zuul_demo.strategy;

import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Configuration;

import com.ctrip.framework.apollo.spring.annotation.ApolloJsonValue;


@Configuration
public class GrayInfo {

	@ApolloJsonValue("${grayVersions:{}}")
	private Map<String, List<String>> grayVersions;
	
	@ApolloJsonValue("${grayIps:{}}")
	private Map<String, List<String>> grayIps;

	public Map<String, List<String>> getGrayVersions() {
		return grayVersions;
	}

	public void setGrayVersions(Map<String, List<String>> grayVersions) {
		this.grayVersions = grayVersions;
	}

	public Map<String, List<String>> getGrayIps() {
		return grayIps;
	}

	public void setGrayIps(Map<String, List<String>> grayIps) {
		this.grayIps = grayIps;
	}
	
}
