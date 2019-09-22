package com.example.ribbon.client;

import java.util.Arrays;
import java.util.List;

import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.LoadBalancerBuilder;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.reactive.LoadBalancerCommand;
import com.netflix.loadbalancer.reactive.ServerOperation;
import rx.Observable;

/**
 * 原生API使用DEMO
 * 
 * @author yinjihuan
 *
 */
public class RibbonNativeClientDemo {
	public static void main(String[] args) {

		// 服务列表
		List<Server> serverList = Arrays.asList(new Server("localhost", 8081), new Server("localhost", 8083));
		// 构建负载实例
		BaseLoadBalancer loadBalancer = LoadBalancerBuilder.newBuilder().buildFixedServerListLoadBalancer(serverList);
		loadBalancer.setRule(new RandomRule());
		// 调用5次来测试效果
		for (int i = 0; i < 5; i++) {
			String result = LoadBalancerCommand.<String>builder().withLoadBalancer(loadBalancer).build()
					.submit(new ServerOperation<String>() {
						public Observable<String> call(Server server) {
							try {
								String addr = "http://" + server.getHost() + ":" + server.getPort();
								System.out.println("调用地址：" + addr);
								return Observable.just("");
							} catch (Exception e) {
								return Observable.error(e);
							}
						}
					}).toBlocking().first();
			System.out.println("调用结果：" + result);
		}

	}
}
