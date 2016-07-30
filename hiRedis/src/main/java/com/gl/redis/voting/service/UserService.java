package com.gl.redis.voting.service;

import com.gl.redis.voting.rao.UserRao;
import com.gl.redis.voting.vo.User;

public class UserService {
	UserRao userRao = new UserRao();
	
	public void addUser(User user){
		userRao.insertOne(user);
	}
	
	public User findUserByIndex(long index){
		User u = (User) userRao.findByIndex(index);
		return u;
	}
	
	public int count(){
		return userRao.countUser();
	}
	
	public void addUserIntoList(User u){
		userRao.insertOneAsSerialization(u);
	}
	
	public long getUserLength(){
		return userRao.getLengthOfUsers();
	}
}
