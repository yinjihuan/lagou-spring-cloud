package com.example.zuul.strategy;

import java.util.concurrent.Callable;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.context.RequestContext;


public class ZuulCallable<V> implements Callable<V> {

	private final Callable<V> delegate;

	private final HttpServletRequest req;

	public ZuulCallable(Callable<V> delegate, HttpServletRequest req) {
		this.delegate = delegate;
		this.req = req;
	}

	@Override
	public V call() throws Exception {
		try {
			RequestContext.getCurrentContext().setRequest(req);
			return this.delegate.call();
		} catch (Exception | Error ex) {
			throw ex;
		}
	}

}