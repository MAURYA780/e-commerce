package com.example.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.ecommerce.dto.MerchantDto;
import com.example.ecommerce.helper.LoginHelper;
import com.example.ecommerce.service.MerchantService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/merchant")
public class MerchantController {
	@Autowired
	MerchantService merchantService;
	
	@Autowired
	MerchantDto merchantDto;
	
	@GetMapping
	public String loadHome() {
		return"Merchant";
	}
	@GetMapping("/signup")
	public String loadSignup(ModelMap map) {
		map.put("merchantDto", merchantDto);
		return"MerchantSignup";
	}
	@PostMapping("/signup")
	public String signup(@Valid MerchantDto  merchantDto, BindingResult result , ModelMap modelMap) {
		if(result.hasErrors())
			return "MerchantSignup";
		else
		return merchantService.signup(merchantDto, modelMap);
	}
	@PostMapping("/verify-Otp")
	public String verify(@RequestParam int otp, @RequestParam int id,ModelMap modelMap) {
		return merchantService.verifyOtp(id, otp,modelMap);
	}
	@PostMapping("/login")
	public String login(LoginHelper helper,ModelMap map)
	{
		return merchantService.login(helper,map);
	}
	

}
