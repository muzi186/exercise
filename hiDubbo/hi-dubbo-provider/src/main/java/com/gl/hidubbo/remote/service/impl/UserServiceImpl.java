package com.gl.hidubbo.remote.service.impl;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

import com.gl.hidubbo.provider.service.UserService;
import com.gl.hidubbo.vo.UserVo;

import sun.misc.BASE64Encoder;

public class UserServiceImpl implements UserService {
	private AtomicLong count = new AtomicLong();

	public List<UserVo> getUsers() {
		List<UserVo> users = new ArrayList<UserVo>();

		UserVo u = new UserVo();
		u.setFirstName("Jim Smoth");
		u.setLastName("Green");

		users.add(u);

		return users;
	}

	@Override
	public UserVo checkUser(String username) {
		String symbol = "C";
		long currentCount = count.getAndIncrement();
		System.out.println("receive invocation:" + username);
		System.err.println(symbol+ "-"+currentCount);

		if (!username.startsWith("evil")) {
			String uuid = UUID.randomUUID().toString();
			UserVo vo = new UserVo();
			vo.setFirstName(symbol + "-"+currentCount);
			vo.setLastName(uuid.substring(10));

			vo.setUsername(username + "-" + currentCount);

			String passwd = "12345678";

			MessageDigest md5;
			String newstr = null;
			try {
				md5 = MessageDigest.getInstance("MD5");
				sun.misc.BASE64Encoder base64en = new BASE64Encoder();
				newstr = base64en.encode(md5.digest(passwd.getBytes("utf-8")));
			} catch (NoSuchAlgorithmException e) {
				newstr = passwd;
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				newstr = passwd;
				e.printStackTrace();
			}

			vo.setPassword(newstr);

			return vo;
		}
		return null;
	}

}
