package com.shc.ecom.common.hazelcast;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.LifecycleService;

public class HazelCastClientUtil {

	private static HazelcastInstance hzInstance = HazelcastClient.newHazelcastClient();
	private static LifecycleService lifecycleService;
	
	static{
		lifecycleService = hzInstance.getLifecycleService();
	}

	// SingletonExample prevents any other class from instantiating

	private HazelCastClientUtil() {
	}
	
	private volatile static Object syncObj = new Object();

	// Providing Global point of access
	public static HazelcastInstance getHazelcastClient() {
		
		//Checking whether the client is still running. If not create a new connection to the server
		if(!lifecycleService.isRunning()){
			synchronized (syncObj) {
				hzInstance = HazelcastClient.newHazelcastClient();
				lifecycleService = hzInstance.getLifecycleService();
			}
		}
		return hzInstance;
	}

}
