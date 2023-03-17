package com.finalProject.dao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import com.finalProject.pojo.AppliedUsers;
import com.finalProject.pojo.Messages;
import com.finalProject.pojo.RentList;
import com.finalProject.pojo.RolesModel;

@Service
public class UserDao extends dao{
	
	public List<RentList> getAllAvailableHouses(String isAvailable){
		Session session = getSession();
		String query = "from Rent r WHERE r.isAvailable=:isAvailable";
		Query q = session.createQuery(query);
		q.setParameter("isAvailable", isAvailable);
		ArrayList<RentList> availableHouses = (ArrayList<RentList>) q.getResultList();
		return availableHouses;
	}
	
	public void sendMessage(Messages message) {
		
		Transaction transaction = null;
		
		try(Session session = getSession()){
			
			transaction = session.beginTransaction();
			session.save(message);
			transaction.commit();
		} 
//			catch(Exception e) {
//			if(transaction!=null) {
//				transaction.rollback();
//			}
//			e.printStackTrace();
//		}
		
	}
	
	public void saveApplicationDetails(AppliedUsers application) {
		Transaction transaction = null;
		
		try(Session session = getSession()){
			
			transaction = session.beginTransaction();
			session.save(application);
			transaction.commit();
		} 
	}
	
	

}
