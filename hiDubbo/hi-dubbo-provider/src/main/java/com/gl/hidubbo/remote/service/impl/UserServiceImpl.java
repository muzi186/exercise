package com.gl.hidubbo.remote.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.gl.hidubbo.provider.service.UserService;
import com.gl.hidubbo.vo.UserVo;

public class UserServiceImpl implements UserService {

	public List<UserVo> getUsers() {
		List<UserVo> users = new ArrayList<UserVo>();
		
		UserVo u = new UserVo();
		u.setFirstName("Jim Smoth");
		u.setLastName("Green");
		
		users.add(u);
		
		return users;
	}

}
