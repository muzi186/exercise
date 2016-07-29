package com.gl.redis.voting;

import com.gl.redis.voting.service.UserService;
import com.gl.redis.voting.vo.User;

public class UserInitializer {
	UserService userService = new UserService();
	boolean amountInitialized = false;
	int maxAmount = 0;
	
	static final int MAX_SIZE = 10000;

	public static void main(String[] args) {
		System.err.println("ST add User - amount " + MAX_SIZE );
		long st = System.currentTimeMillis();
		UserInitializer initializer = new UserInitializer();
		initializer.addTestUsers(MAX_SIZE);
		long ed = System.currentTimeMillis();
		System.err.println("ED add User - amount " + MAX_SIZE + " eclapse : "+ ((ed -st)/1000.0));
	}
	
	public void addTestUsers(int maxSize){
		for(int i=0; i < maxSize; i++){
			User u = genUser();
			userService.addUser(u);
		}
	}
	
	private User genUser(){
		int id = genId();
		String username = genUsername(id);
		return new User(id,username);
	}
	
	private int genId(){
		initialMaxAmount();
		return ++maxAmount;
	}
	
	private String genUsername(int id){
		return "test-"+id;
	}

	private void initialMaxAmount() {
		if (!amountInitialized) {
			maxAmount = userService.count();
			amountInitialized = true;
		}

	}
}
