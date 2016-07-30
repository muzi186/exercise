package com.gl.redis.voting;

import java.util.Date;

import com.gl.redis.voting.service.UserService;
import com.gl.redis.voting.vo.User;

public class SerializedUserInitializer {
	UserService service = new UserService();
	int sizeToInsert = 100000;
	int length = 0;

	public static void main(String[] args) {
		SerializedUserInitializer initializer = new SerializedUserInitializer();
		initializer.initialize();
	}

	public void initialize() {
		System.out.println("Start at : " + (new Date().toString()));
		length = (int) service.getUserLength();

		
		for(int i = 0 ; i<sizeToInsert; i++){
			service.addUserIntoList(mockUser());
		}
		
		System.out.println("Finished at : " + (new Date().toString()));
		
		System.out.println("Length:"+ service.getUserLength());
	}

	public User mockUser() {
		int id = (++length);
		return new User(id, "test-serializable-"+id);
	}
}
