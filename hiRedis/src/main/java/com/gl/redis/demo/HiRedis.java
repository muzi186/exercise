package com.gl.redis.demo;

import com.gl.redis.JedisFactory;

import redis.clients.jedis.Jedis;

public class HiRedis {

	public static void main(String[] args) {
		JedisFactory jf = JedisFactory.getInstance();
		Jedis jedis = jf.getJedis();
		
		String key = "COUNT";
		Integer value = 0;
		
		System.out.println(String.format("SET %s => %d", key, value));
		jedis.set(key, String.valueOf(value));
		
		String storedValue = jedis.get(key);
		System.out.println(String.format("GET %s => %s", key, storedValue));
		
		System.out.println("INCRBY 1");
		jedis.incrBy(key, 1);
		
		storedValue = jedis.get(key);
		System.out.println(String.format("GET %s => %s", key, storedValue));
		
		jf.closeJedis(jedis);
	}

}
