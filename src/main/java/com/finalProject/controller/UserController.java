package com.finalProject.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.finalProject.dao.UserDao;
import com.finalProject.pojo.AppliedUsers;
import com.finalProject.pojo.Messages;
import com.finalProject.pojo.RolesModel;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired(required=false)
	UserDao userdao;
	
	@PostMapping("/userprofile.htm")
	public String getProfile(HttpServletRequest req, HttpSession session) {
		
		if(session.getId() != null) {
			System.out.println("In user profile:" + session.getId());
			
			RolesModel user = (RolesModel) req.getSession().getAttribute("userDetails");
			req.setAttribute("username", user.getUsername());
			req.setAttribute("phone", user.getPhone());
			req.setAttribute("emailid", user.getEmailid());
			req.setAttribute("name", user.getName());
			return "profile";
			
		}
		return "user-home";
	}
	
	@PostMapping("/sendmessage.htm")
	public String sendMessage(HttpServletRequest req) {
		
		RolesModel owner = (RolesModel) req.getSession().getAttribute("ownerDetails");
		RolesModel user = (RolesModel) req.getSession().getAttribute("userDetails");
		
		String user_name = user.getUsername();
		String owner_name = req.getParameter("hiddenOwnerUsername");
		String owner_id = req.getParameter("hiddenRoleId");
		String message = req.getParameter("message");
		String hid = req.getParameter("hiddenHouseId");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		
		String messageDate = dtf.format(now);
	
		if(user_name.isEmpty() || owner_name.isEmpty() || message.isEmpty() || messageDate.isEmpty()) {
			
		}
		
		Messages newMessage = new Messages();
		userdao = new UserDao();
		
		newMessage.setUser_name(user_name);
		newMessage.setOwner_name(owner_name);
		newMessage.setMessage(message);
		newMessage.setDate(messageDate);
		newMessage.setUserid(user.getId());
		long ownerid = Long.parseLong(owner_id);
		newMessage.setOwnerid(ownerid);
		long houseid = Long.parseLong(hid);
		newMessage.setHouseId(houseid);
		
		userdao.sendMessage(newMessage);
		
		//req.setAttribute("user", user);
		return "success";
		
	}
	
	@GetMapping("/applyForHouse.htm")
	public String openApplicationPage(HttpServletRequest req) {
		String houseid = req.getParameter("hiddenHouseId");
		req.setAttribute("houseId", houseid);
		String ownername = req.getParameter("hiddenOwnerName");
		req.setAttribute("ownername", ownername);
		String ownerid = req.getParameter("hiddenRoleId");
		req.setAttribute("ownerid", ownerid);
		String userid = req.getParameter("hiddenUserId");
		req.setAttribute("userid", userid);
		return "application-page";
	}
	
	
	@PostMapping("/submitApplication.htm")
	public String submitApplication(HttpServletRequest req) {
		String username = req.getParameter("user");
		String city = req.getParameter("city");
		String occupation = req.getParameter("occupation");
		String salary = req.getParameter("salary");
		String NoOfPeople = req.getParameter("NoOfPeople");
		String preferences = req.getParameter("preferences");
		String houseId = req.getParameter("hiddenHouseId");
		String ownername = req.getParameter("hiddenOwnerName");
		String ownerid = req.getParameter("hiddenOwnerId");
		
		
		if(username.isEmpty() || city.isEmpty() || occupation.isEmpty() || salary.isEmpty() || NoOfPeople.isEmpty() || ownername.isEmpty() || houseId.isEmpty()) {
			return "error-page";
		}
		
		RolesModel user = (RolesModel) req.getSession().getAttribute("userDetails");
		
		AppliedUsers newApplication = new AppliedUsers();
		UserDao userdao = new UserDao();
		
		long numberOfPeople = Long.parseLong(NoOfPeople);
		long house_id = Long.parseLong(houseId);
		long owner_id = Long.parseLong(ownerid);
		
		newApplication.setUser(username);
		newApplication.setCity(city);
		newApplication.setNoOfPeople(numberOfPeople);
		newApplication.setOccupation(occupation);
		newApplication.setSalary(salary);
		newApplication.setPreferences(preferences);
		newApplication.setOwner(ownername);
		newApplication.setHouseId(house_id);
		newApplication.setOwnerid(owner_id);
		newApplication.setUserid(user.getId());
		
		userdao.saveApplicationDetails(newApplication);
		
		req.setAttribute("applicationSuccessMsg", "Application sent successfully");
		return "success";
		
	}
}
