package com.gl.redis.util;

public final class RedisUtil {
	private RedisUtil(){}
	
	public static String calculateKeyFromClass(Class<?> type, Object id){
		String key = type.getName();
		key = key.replaceAll("\\.", ":");
		key += ":"+id.toString();
		return key;
	}
}
