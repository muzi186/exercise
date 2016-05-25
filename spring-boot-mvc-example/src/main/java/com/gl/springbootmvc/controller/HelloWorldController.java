package com.gl.springbootmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by gavin on 16-5-25.
 */
@Controller
public class HelloWorldController {
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public ModelAndView hello() {
		return new ModelAndView("hello").addObject("name", "Yashwant");
	}
}
