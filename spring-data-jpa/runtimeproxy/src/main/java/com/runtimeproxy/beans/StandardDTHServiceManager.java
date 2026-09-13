package com.runtimeproxy.beans;

public class StandardDTHServiceManager implements DTHServiceManager {
	@Override
	public String troubleShoot(String customerId) {
		System.out.println("signal check..");
		System.out.println("verifying the configuration/settings of the set-top box");

		return "no active subscription found";
	}
}
