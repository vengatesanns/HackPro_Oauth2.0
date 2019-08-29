package com.hackpro.appsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	
	@GetMapping("/")
	public String getMessage()
	{
		return "Hello World!!!";
	}
	
	@GetMapping("/login")
	public String getLoginPage()
	{
		return "Hello World!!!, Login Successfully!!!";
	}
	
	@GetMapping("/logout-success")
	public String getLogoutPage()
	{
		return "Hello World!!!, Logout Successfully!!!";
	}
}
