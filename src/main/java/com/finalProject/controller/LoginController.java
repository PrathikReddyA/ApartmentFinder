package com.finalProject.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.finalProject.dao.AdminDao;
import com.finalProject.dao.LoginDao;
import com.finalProject.dao.OwnerDao;
import com.finalProject.dao.UserDao;
import com.finalProject.pojo.RentList;
import com.finalProject.pojo.RolesModel;

@Controller
public class LoginController {
	
	@Autowired(required=false)
	OwnerDao ownerdao;
	
	@GetMapping("/login-user.htm")
	public String loginUser() {
		return "login-user";
	}
	
	@GetMapping("/login-owner.htm")
	public String loginOwner() {
		return "login-owner";
	}
	
	@GetMapping("/login-admin.htm")
	public String loginAdmin() {
		return "login-admin";
	}
	
	@PostMapping("/loginToUserHome.htm")
	public String userLoginCheck(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username + " " +password);
		LoginDao userlogindao = new LoginDao();
		
		RolesModel user = userlogindao.getUserLogin(username, password);
		
		UserDao userdao = new UserDao();
		
		ArrayList availableHouses = (ArrayList) userdao.getAllAvailableHouses("true");
		if(availableHouses!=null) {
			request.setAttribute("availablehouses", availableHouses);
			System.out.println(availableHouses);
		}
		
		
		
		
		
		if(user == null) {
			request.setAttribute("msg", "Please enter correct user username or password");
			return "error-page";
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("userDetails", user);
		System.out.println("In login controller:"+session.getId());
		
		request.setAttribute("user", user.getUsername());
		request.setAttribute("userid", user.getId());
		//System.out.println(user.getEmailid() + " " + user.getPassword());
		
		return "user-home";
	}
	
	@PostMapping("/LoginToOwnerHome.htm")
	public String ownerLoginCheck(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username + " " +password);
		LoginDao userdao = new LoginDao();
		
		
		
		RolesModel owner = userdao.getOwnerLogin(username, password);
		
		if(owner==null) {
			request.setAttribute("msg", "Please enter correct user username or password");
			return "error-page";
		}
		
		ownerdao = new OwnerDao();
		
		ArrayList list =  ownerdao.getAllMessages(owner.getUsername());
		request.setAttribute("messageInfo", list);
		
		HttpSession session = request.getSession();
		session.setAttribute("ownerDetails", owner);
		
		List applicationList = ownerdao.getAllApplications(username);
		request.setAttribute("applicationList", applicationList);
		
		request.setAttribute("owner", owner.getUsername());
		return "owner-home";
	}
	
	@PostMapping("/LoginToAdmin.htm")
	public String adminLoginCheck(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("adminUsername");
		String password = request.getParameter("adminPassword");
		System.out.println(username + " " +password);
		LoginDao userdao = new LoginDao();
		RolesModel admin = userdao.getAdminLogin(username, password);
		
		AdminDao admindao = new AdminDao();
		List<RolesModel> ownerlist = admindao.getAllOwners();
		request.setAttribute("ownerlist", ownerlist);
		List<RolesModel> userlist = admindao.getAllUsers();
		request.setAttribute("userlist", userlist);
		
		if(admin == null) {
			request.setAttribute("msg", "Please enter correct admin username or password");
			return "error-page";
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("adminDetails", admin);
		
		request.setAttribute("admin", admin.getUsername());
		return "admin-home";
	}
	
	@GetMapping("/logout.htm")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		System.out.println("in logout "+session.getId());
		if(session != null) {
			session.invalidate();
		}
		return "home";
	}
	
	 
}
