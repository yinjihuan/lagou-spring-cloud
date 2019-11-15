package com.cxytiandi.auth.strategy;

import java.util.concurrent.Callable;
import com.cxytiandi.auth.context.ContextHolder;
import com.cxytiandi.auth.context.RequestContext;


public class AuthCallable<V> implements Callable<V> {

	private final Callable<V> delegate;

	private final RequestContext requestContext;

	public AuthCallable(Callable<V> delegate, RequestContext requestContext) {
		this.delegate = delegate;
		this.requestContext = requestContext;
	}

	@Override
	public V call() throws Exception {
		try {
			ContextHolder.setCurrentContext(requestContext);
			return this.delegate.call();
		} catch (Exception | Error ex) {
			throw ex;
		}
	}

}