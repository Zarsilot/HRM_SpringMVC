package com.icss.system;

import redis.clients.jedis.Jedis;
/*
 * 
 * 2016-09-13
 */
public class RedisUtil {
	
	public static void initRedis(String redisIp){
		
	}
	
	public static Jedis getRedis(){
		Jedis redisClient = new Jedis(redisIp,redisPort);
		return redisClient;
	}
}
