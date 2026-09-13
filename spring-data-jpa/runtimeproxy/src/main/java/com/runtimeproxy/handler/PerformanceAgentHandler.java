package com.runtimeproxy.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Calendar;

public class PerformanceAgentHandler implements InvocationHandler {
	private Object target;

	public PerformanceAgentHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		long startTime = Calendar.getInstance().getTimeInMillis();
		Object ret = method.invoke(target, args);
		long endTime = Calendar.getInstance().getTimeInMillis();

		long executionTime = endTime - startTime;
		System.out.println("method : " + method.getName() + " has taken executionTime: " + executionTime + " ms");
		return ret;
	}

}
