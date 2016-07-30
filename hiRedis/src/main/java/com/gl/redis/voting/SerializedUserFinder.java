package com.gl.redis.voting;

import com.gl.redis.voting.service.UserService;

public class SerializedUserFinder {
	UserService service = new UserService();

	public static void main(String[] args) {
		new SerializedUserFinder().find();
	}

	
	public void find(){
		long len = service.getUserLength();
		for(long i = 0L; i < len; i++){
			System.out.println(service.findUserByIndex(i));
		}
	}
}
