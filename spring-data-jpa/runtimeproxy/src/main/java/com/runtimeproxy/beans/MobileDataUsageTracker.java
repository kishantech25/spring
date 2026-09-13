package com.runtimeproxy.beans;

import java.security.SecureRandom;

public class MobileDataUsageTracker implements UsageTracker {

	@Override
	public String usageReport(String customerId) {
		SecureRandom random = new SecureRandom();

		System.out.println("pulling the usage statistics");
		System.out.println("generating usage report");

		return "data cost: " + random.nextDouble(10000);
	}

}
