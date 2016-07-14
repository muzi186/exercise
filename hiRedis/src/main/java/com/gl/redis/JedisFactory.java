package com.gl.redis;

import java.util.ResourceBundle;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public final class JedisFactory {
	private static final JedisFactory instance = new JedisFactory();
	
	private String propertyFileName = "redis";
	
	private JedisPool pool;
	private ResourceBundle r;
	
	private JedisFactory(){
		r = ResourceBundle.getBundle(propertyFileName);
		if (r == null) {  
	        throw new IllegalArgumentException(  
	                "[redis.properties] is not found!");  
	    }
		
		pool = createJedisPool(r);
	}
	
	private JedisPool createJedisPool(ResourceBundle bundle){
		JedisPoolConfig config = createJedisPoolConfig(r);
		String ip = bundle.getString("redis.ip"); 
        int port = Integer.valueOf(bundle.getString("redis.port"));
        
        return new JedisPool(config, ip, port);
	}
	
	private JedisPoolConfig createJedisPoolConfig(ResourceBundle bundle){
		JedisPoolConfig config = new JedisPoolConfig();  
	    config.setMaxActive(Integer.valueOf(bundle  
	            .getString("redis.pool.maxActive")));  
	    config.setMaxIdle(Integer.valueOf(bundle  
	            .getString("redis.pool.maxIdle")));  
	    config.setMaxWait(Long.valueOf(bundle.getString("redis.pool.maxWait")));  
	    config.setTestOnBorrow(Boolean.valueOf(bundle  
	            .getString("redis.pool.testOnBorrow")));  
	    config.setTestOnReturn(Boolean.valueOf(bundle  
	            .getString("redis.pool.testOnReturn")));
	    
	    return config;
	}
	
	public static JedisFactory getInstance(){
		return instance;
	}
	
	public Jedis getJedis(){
		return pool.getResource();
	}
	
	public void returnJedis(Jedis j){
		pool.returnResource(j);
	}
}
