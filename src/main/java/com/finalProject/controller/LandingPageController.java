package com.finalProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LandingPageController {
	
	@GetMapping("/roles-user.htm")
	public String navToUserLogin() {
		return "roles-user";
	}
	
	@GetMapping("/roles-owner.htm")
	public String navToOwnerLogin() {
		return "roles-owner";
	}
	
	@GetMapping("/roles-admin.htm")
	public String navToAdminLogin() {
		return "login-admin";
	}
}
