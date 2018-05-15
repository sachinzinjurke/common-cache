package com.shc.ecom.common.hazelcast;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hazelcast.core.Hazelcast;

public class StartHazelCast {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(StartHazelCast.class.getName());
	
	
	public static void main(String[] args) {
		Hazelcast.newHazelcastInstance();
		LOGGER.info(":::::: Finished loading hazelcast ::::");
	}
	
}