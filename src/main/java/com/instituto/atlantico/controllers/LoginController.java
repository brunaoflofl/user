package com.instituto.atlantico.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String login(HttpSession session) {
		return "login";
	}		
	

	@RequestMapping("/")
	public String index(HttpSession session) {
		return "index";
	}

	@RequestMapping("/logout")
	String logout(HttpSession session) {
		return "login";

	}

	@RequestMapping("/admin")
	public String admin(HttpSession session) {
		return "admin";
	}

	@RequestMapping("/success")
	public String success(HttpSession session) {
		return "success";
	}

}
