package com.guruguruzom.dbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.guruguruzom.dbc.service.UserService;

@Controller
public class UserController {
	
	@Autowired UserService userService;
	@GetMapping(value = {"", "/"})
	public String getUserCount(Model model) {
		int userCount = userService.getUserCount();
		System.out.println(userCount);
		model.addAttribute("userCount",userCount);
		return "user";
	}
}
