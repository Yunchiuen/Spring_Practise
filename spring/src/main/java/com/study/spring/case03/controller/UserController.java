package com.study.spring.case03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.study.spring.case03.service.UserService;

@Controller
public class UserController {

	//private UserService userService = new UserServiceImpl();
	@Autowired
	private UserService userService;

	public UserController() {
		System.out.println("UserController");
	}

	public void appendUser() {
		userService.addUser();
	}
}
