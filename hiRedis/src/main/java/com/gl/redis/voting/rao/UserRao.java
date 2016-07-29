package com.gl.redis.voting.rao;

import com.gl.redis.JedisFactory;
import com.gl.redis.util.RedisUtil;
import com.gl.redis.voting.vo.User;

import redis.clients.jedis.Jedis;

public class UserRao {
	private JedisFactory jf = JedisFactory.getInstance();
	
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
		
		return Integer.valueOf(amount);
	}
}
