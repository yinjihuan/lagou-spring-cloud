package com.example.hystrix.plugin;

import java.util.List;

import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixEventType;
import com.netflix.hystrix.HystrixCommandProperties.ExecutionIsolationStrategy;
import com.netflix.hystrix.strategy.eventnotifier.HystrixEventNotifier;
/**
 * 事件通知插件，可用于收集信息以及监控告警
 * @author yinjihuan
 *
 */
public class CustomHystrixEventNotifier extends HystrixEventNotifier {

	@Override
	public void markCommandExecution(HystrixCommandKey key, ExecutionIsolationStrategy isolationStrategy, int duration,
			List<HystrixEventType> eventsDuringExecution) {
		System.err.println("markCommandExecution:" + key.name() + "\t" + isolationStrategy.name() + "\t" + duration + "\t" + eventsDuringExecution.toString());
	}
	
	@Override
	public void markEvent(HystrixEventType eventType, HystrixCommandKey key) {
		System.err.println("markEvent:" + key.name() + "\t" + eventType.name());
	}
}
