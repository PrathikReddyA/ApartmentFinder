package com.finalProject.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.finalProject.dao.OwnerDao;
import com.finalProject.dao.LoginDao;
import com.finalProject.pojo.RentList;
import com.finalProject.pojo.RolesModel;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class OwnerController {

	@PostMapping("/ownerprofile.htm")
	public String getProfile(HttpServletRequest req) {
		
		RolesModel owner = (RolesModel) req.getSession().getAttribute("ownerDetails");
		req.setAttribute("username", owner.getUsername());
		req.setAttribute("phone", owner.getPhone());
		req.setAttribute("emailid", owner.getEmailid());
		req.setAttribute("name", owner.getName());
		return "profile";
		
	}
	
//	@GetMapping("/")
//	public String getMessages(HttpServletRequest request) {
//		RolesModel owner = (RolesModel) request.getSession().getAttribute("ownerDetails");
//		OwnerDao ownerdao = new OwnerDao();
//		ArrayList list =  ownerdao.getAllMessages(owner.getUsername());
//		request.setAttribute("messageInfo", list);
//		request.setAttribute("messageSize", list.size());
//		return null;
//	}
//	
	
	@PostMapping("/addHouse.htm")
	public String addHouseToRent(HttpServletRequest req) {
		String unitNumber = req.getParameter("unitNumber");
		String street = req.getParameter("street");
		String city = req.getParameter("city");
		String state = req.getParameter("state");
		String pincode = req.getParameter("pincode");
		String country = req.getParameter("country");
		String houseType = req.getParameter("houseType");
		String details = req.getParameter("details");
		String area = req.getParameter("area");
		String price = req.getParameter("price");
		String contact = req.getParameter("contact");
		String amenities = req.getParameter("amenities");
		String username = req.getParameter("username");
		OwnerDao newHouse = new OwnerDao();
		
		if(unitNumber.isEmpty() || street.isEmpty() || city.isEmpty() || state.isEmpty() || pincode.isEmpty() || country.isEmpty() || 
				houseType.isEmpty() || price.isEmpty() || contact.isEmpty()) {
			
			req.setAttribute("msg", "enter required fields for new house");
			return "error-msg";
		}
		RolesModel owner = (RolesModel) req.getSession().getAttribute("ownerDetails");
		RentList rent = new RentList();
		
		rent.setUnitNumber(unitNumber);
		rent.setStreet(street);
		rent.setCity(city);
		rent.setState(state);
		rent.setPincode(pincode);
		rent.setCountry(country);
		rent.setHouseType(houseType);
		rent.setDetails(details);
		rent.setArea(area);
		rent.setPrice(price);
		rent.setContact(contact);
		rent.setAmenities(amenities);
		rent.setUsername(username);
		rent.setIsAvailable("true");
		//long oid = Long.parseLong(ownerDetails);
		rent.setRoleid(owner.getId());
		newHouse.addnewHouseToRent(rent);
		
		req.setAttribute("owner", owner);
		return "success";
	}
	
	@GetMapping("/rentedHouses.htm")
	public String ownerListedHouses(HttpServletRequest req) {
		RolesModel owner = (RolesModel) req.getSession().getAttribute("ownerDetails");
		OwnerDao ownerdao = new OwnerDao();
		System.out.println(owner.getUsername());
		List rentlist = ownerdao.getAllListedHouses(owner.getUsername());
		req.setAttribute("ownerRentList", rentlist);
		String appId = req.getParameter("appId");
		req.setAttribute("appId", appId);
		return "listedHousesByOwner";
	}
	
	@GetMapping("/viewApplicationRequests.htm")
	public String displayAllApplications(HttpServletRequest req) {
		RolesModel owner = (RolesModel) req.getSession().getAttribute("ownerDetails");
		OwnerDao ownerdao = new OwnerDao();
		System.out.println(owner.getUsername());
		List applicationList = ownerdao.getAllApplications(owner.getUsername());
		req.setAttribute("applicationList", applicationList);
		return "view-applications";
	}
	
	@GetMapping("/removeHouse.htm")
	public String deleteHouse(HttpServletRequest request) {
		RolesModel owner = (RolesModel) request.getSession().getAttribute("ownerDetails");
		String id = request.getParameter("rentId");
		OwnerDao ownerdao = new OwnerDao();
		ownerdao.deleteHouse(id);
		List rentlist = ownerdao.getAllListedHouses(owner.getUsername());
		request.setAttribute("ownerRentList", rentlist);
		return "listedHousesByOwner";
	}
	
	
	@GetMapping("/removeMessage.htm")
	public String deleteMessage(HttpServletRequest request) {
		RolesModel owner = (RolesModel) request.getSession().getAttribute("ownerDetails");
		String id = request.getParameter("msgId");
		OwnerDao ownerdao = new OwnerDao();
		ownerdao.deleteMessage(id);
		List msgs = ownerdao.getAllMessages(owner.getUsername());
		request.setAttribute("messageInfo", msgs);
		return "owner-home";
	}
	
	@PostMapping("/approveApplication.htm")
	public String approveApplication(HttpServletRequest request) {
		String userid = request.getParameter("hiddenUserid");
		String username = request.getParameter("hiddenUsername");
		String applicationId = request.getParameter("hiddenApplicationId");
		String houseid = request.getParameter("hiddenHouseId");
		OwnerDao ownerdao = new OwnerDao();
		long applnId = Long.parseLong(applicationId);
		long uid = Long.parseLong(userid);
		long hid = Long.parseLong(houseid);
		ownerdao.approveApplication(username, applnId, hid);
		RolesModel owner = (RolesModel) request.getSession().getAttribute("ownerDetails");
		List applicationList = ownerdao.getAllApplications(owner.getUsername());
		request.setAttribute("applicationList", applicationList);
		return "view-applications";
	}
}
