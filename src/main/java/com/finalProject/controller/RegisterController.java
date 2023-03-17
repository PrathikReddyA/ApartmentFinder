package com.finalProject.controller;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.finalProject.dao.RegisterDao;
import com.finalProject.pojo.RolesModel;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class RegisterController {

	@GetMapping("/register-user.htm")
	public String registerUser() {
		return "register-user";
	}
	
	@GetMapping("/register-owner.htm")
	public String registerOwner() {
		return "register-owner";
	}
	
	
	
	@PostMapping("/register-user.htm")
	public String userRegisterCheck(HttpServletRequest req, HttpServletResponse resp) {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String emailid = req.getParameter("emailid");
		String phone = req.getParameter("phone");
		String name = req.getParameter("name");
		String role = "user";
		
		
		
		RegisterDao register = new RegisterDao();
		
		RolesModel checkuser = register.checkRoleExists(username);
		if(checkuser != null) {
			System.out.println("username exists");
			req.setAttribute("msg", "Username already exists.");
			return "error-page";
		}
		
		if(username.isEmpty() || password.isEmpty() || emailid.isEmpty() || name.isEmpty() || phone.isEmpty()) {
			req.setAttribute("msg", "one of the values is empty");
			return "error-page";
		}
		
		RolesModel user = new RolesModel();
		
		user.setUsername(username);
		user.setPassword(password);
		user.setName(name);
		user.setEmailid(emailid);
		user.setPhone(phone);
		user.setRole(role);
		
		register.register(user);
		
		return "success";
		
	}
	
	@PostMapping("/register-owner.htm")
	public String ownerRegisterCheck(HttpServletRequest req, HttpServletResponse resp) {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String emailid = req.getParameter("emailid");
		String phone = req.getParameter("phone");
		String name = req.getParameter("name");
		String role = "owner";
		
		
		RegisterDao register = new RegisterDao();
		
		RolesModel checkuser = register.checkRoleExists(username);
		if(checkuser != null) {
			System.out.println("username exists");
			req.setAttribute("msg", "Username already exists.");
			return "error-page";
		}
		
		if(username.isEmpty() || password.isEmpty() || emailid.isEmpty() || name.isEmpty() || phone.isEmpty()) {
			req.setAttribute("msg", "one of the values is empty");
			return "error-page";
		}
		
		RolesModel owner = new RolesModel();
		
		owner.setUsername(username);
		owner.setPassword(password);
		owner.setName(name);
		owner.setEmailid(emailid);
		owner.setPhone(phone);
		owner.setRole(role);
		
		register.register(owner);
		
		return "success";
		
	}
	
	
}
