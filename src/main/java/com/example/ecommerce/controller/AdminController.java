package com.example.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ecommerce.helper.LoginHelper;
import com.example.ecommerce.service.AdminService;

import jakarta.servlet.http.HttpSession;
@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@RequestMapping
	public String loadHome() {
		return "Admin";
	}

	@GetMapping("/signup")
	public String loadSignup() {
		return"AdminSignup";
	}
	
	@PostMapping("/login")
	public String login(LoginHelper helper,ModelMap map,HttpSession session)
	{
		return adminService.login(helper,map,session);
	}
}
