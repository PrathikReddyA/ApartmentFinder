package com.finalProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.finalProject.dao.AdminDao;
import com.finalProject.dao.OwnerDao;
import com.finalProject.pojo.RentList;
import com.finalProject.pojo.RolesModel;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AdminController {
	
	@Autowired
	AdminDao admindao;
	
	@GetMapping("/removeOwner.htm")
	public String removeOwner(HttpServletRequest request) {
		
//		RolesModel owner = (RolesModel) request.getSession().getAttribute("ownerDetails");
		
		String id = request.getParameter("ownerId");
		admindao = new AdminDao();
		admindao.removeOwner(id);
		List<RolesModel> ownerlist = admindao.getAllOwners();
		request.setAttribute("ownerlist", ownerlist);
		List<RolesModel> userlist = admindao.getAllUsers();
		request.setAttribute("userlist", userlist);
		return "admin-home";
	}
	
	@GetMapping("/removeUser.htm")
	public String removeUser(HttpServletRequest request) {
				
		String id = request.getParameter("userId");
		AdminDao admindao = new AdminDao();
		admindao.removeOwner(id);
		List<RolesModel> ownerlist = admindao.getAllOwners();
		request.setAttribute("ownerlist", ownerlist);
		List<RolesModel> userlist = admindao.getAllUsers();
		request.setAttribute("userlist", userlist);
		return "admin-home";
	}
}
