package com.runtimeproxy.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import com.runtimeproxy.beans.DTHServiceManager;
import com.runtimeproxy.beans.StandardDTHServiceManager;
import com.runtimeproxy.handler.PerformanceAgentHandler;

public class RuntimeProxyTest {
	public static void main(String[] args) {
		DTHServiceManager dthServiceManager = new StandardDTHServiceManager();
		InvocationHandler performanceAgentInvocationHandler = new PerformanceAgentHandler(dthServiceManager);

		DTHServiceManager performanceMonitorDTHServiceManager = (DTHServiceManager) Proxy.newProxyInstance(
				DTHServiceManager.class.getClassLoader(), new Class<?>[] { DTHServiceManager.class },
				performanceAgentInvocationHandler);
		
		String report = performanceMonitorDTHServiceManager.troubleShoot("c038955");
		System.out.println(report);
	}
}
