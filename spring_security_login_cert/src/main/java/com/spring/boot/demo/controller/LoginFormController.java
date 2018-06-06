package com.spring.boot.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@RestController
@Controller
public class LoginFormController {
	static{
		System.out.println("###static blk in LoginFormController");
	}
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loginProcess() {
		System.out.println("###loginProcess() method in LoginFormController class");
		//return "redirect:/loginsuccess"; //not working
		return "loginsuccess";
	}
}
