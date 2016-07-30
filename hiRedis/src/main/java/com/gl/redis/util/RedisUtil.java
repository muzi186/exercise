package com.gl.redis.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public final class RedisUtil {
	private RedisUtil() {
	}

	public static String calculateKeyFromClass(Class<?> type, Object id) {
		String key = type.getName();
		key = key.replaceAll("\\.", ":");
		if (id != null) {
			key += ":" + id.toString();
		}
		return key;
	}
	
	public static byte[] serialize(Serializable obj){
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(obj);
			
			
			return baos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				baos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		return null;
	}
	
	public static Serializable deserialize(byte[] contents){
		ByteArrayInputStream bais = new ByteArrayInputStream(contents);
		try {
			ObjectInputStream ois = new ObjectInputStream(bais);
			
			return (Serializable) ois.readObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
