package com.gl.redis.voting.rao;

import java.io.Serializable;

import com.gl.redis.JedisFactory;
import com.gl.redis.util.RedisUtil;
import com.gl.redis.voting.vo.User;

import redis.clients.jedis.Jedis;

public class UserRao {
	private JedisFactory jf = JedisFactory.getInstance();
	
	public void insertOneAsSerialization(User user){
		Jedis jedis = jf.getJedis();
		String listKey = RedisUtil.calculateKeyFromClass(User.class, null);
		byte[] serializedObj = RedisUtil.serialize(user);
		
		jedis.lpush(listKey.getBytes(), serializedObj);
		System.out.println("Added - " + listKey);
		
		jf.closeJedis(jedis);
	}
	
	public Serializable findByIndex(long index){
		Jedis jedis = jf.getJedis();
		String listKey = RedisUtil.calculateKeyFromClass(User.class, null);
		
		byte[] serializedObj =  jedis.lindex(listKey.getBytes(), index);
		
		jf.closeJedis(jedis);
		
		return RedisUtil.deserialize(serializedObj);
	}
	
	public Long getLengthOfUsers(){
		Jedis j = jf.getJedis();
		String listKey = RedisUtil.calculateKeyFromClass(User.class, null);
		
		long len = j.llen(listKey.getBytes());
		
		jf.closeJedis(j);
		
		return len;
	}
	
	public void insertOne(User user){
		Jedis jedis = jf.getJedis();
		String key = RedisUtil.calculateKeyFromClass(user.getClass(), user.getId());
		jedis.hset(key, "username", user.getUsername());
		
		System.out.println("Added - "+ key);
		
		String amountKey = RedisUtil.calculateKeyFromClass(User.class, "amount");
		String amount = jedis.get(amountKey);
		
		if(amount == null){
			jedis.set(amountKey, "1");
		}else{
			jedis.incr(amountKey);
		}
		jf.closeJedis(jedis);
	}
	
	public int countUser(){
		Jedis jedis = jf.getJedis();
		String key = RedisUtil.calculateKeyFromClass(User.class, "amount");
		String amount = jedis.get(key);
		
		if(amount == null){
			//jedis.set(key, "0");
			return 0;
		}
		
		jf.closeJedis(jedis);
		
		return Integer.valueOf(amount);
	}
}
