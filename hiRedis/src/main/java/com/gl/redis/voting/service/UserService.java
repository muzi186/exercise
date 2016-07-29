package com.gl.redis.voting.service;

import com.gl.redis.voting.rao.UserRao;
import com.gl.redis.voting.vo.User;

public class UserService {
	UserRao userRao = new UserRao();
	
	public void addUser(User user){
		userRao.insertOne(user);
	}
	
	public int count(){
		return userRao.countUser();
	}
}
