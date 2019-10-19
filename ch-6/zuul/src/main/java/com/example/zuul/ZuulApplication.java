package com.example.zuul;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import com.netflix.zuul.FilterFileManager;
import com.netflix.zuul.FilterLoader;
import com.netflix.zuul.groovy.GroovyCompiler;
import com.netflix.zuul.groovy.GroovyFileFilter;
import com.netflix.zuul.monitoring.MonitoringHelper;

@EnableZuulProxy
@SpringBootApplication
public class ZuulApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ZuulApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// 定时从一个目录加载Groovy的Filter
		FilterLoader.getInstance().setCompiler(new GroovyCompiler());
		try {
			FilterFileManager.setFilenameFilter(new GroovyFileFilter());
			FilterFileManager.init(5, "/Users/yinjihuan/Downloads/filters");
		} catch (Exception e) {
			throw new RuntimeException();
		}

	}

}
