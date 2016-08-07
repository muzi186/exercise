package com.gl.hidubbo.client;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gl.hidubbo.provider.service.UserService;
import com.gl.hidubbo.vo.UserVo;

public class Consumer {

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "spring/application-context-reference.xml" });
		context.start();

		UserService userService = (UserService) context.getBean("userService"); //

		//
		List<UserVo> list = userService.getUsers();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		}

		for (int i = 0; i < 10; i++) {
			UserVo vo = userService.checkUser("666666");
			System.out.println(vo);
		}

		System.in.read();
	}

}