package com.instituto.atlantico.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String login(HttpSession session, HttpServletRequest request) {
		return "login";
	}		
	

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/logout")
	String logout(HttpSession session) {
		return "login";

	}

	@RequestMapping("/admin")
	public String admin() {
		return "admin";
	}

	@RequestMapping("/success")
	public String success() {
		return "success";
	}

}
