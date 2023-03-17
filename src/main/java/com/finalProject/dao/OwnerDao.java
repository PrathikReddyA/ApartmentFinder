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
public class OwnerDao extends dao{

	public void addnewHouseToRent(RentList rent) {
		
		Transaction transaction = null;
		
		try(Session session = getSession()){
			
			transaction = session.beginTransaction();
			session.save(rent);
			transaction.commit();
		} 
//			catch(Exception e) {
////			if(transaction!=null) {
////				transaction.rollback();
////			}
////			e.printStackTrace();
////		}
//		
	}
	
//	public List<RentList> ownerListedHouses(String username){
//		
//		Query q = getSession().createQuery("FROM Rent r WHERE r.username=:username");
//		q.setParameter("username", username);
//		List<RentList> rentlist = new ArrayList<>();
//		for(Object o : q.list())
//			rentlist.add((RentList)o);
//		
//		System.out.println(rentlist);
//		
//		return rentlist;
//	}
	
	
    public List<RentList> getAllListedHouses(String username) {
        Session session = getSession();
        String query = "from Rent r WHERE r.username=:username";
        Query q = session.createQuery(query);
        q.setParameter("username", username);
        if(q.list().size() != 0) {
	        List<RentList> rentlist = q.list();
	        return rentlist;
        }
        return null;
    }
    
    public List<AppliedUsers> getAllApplications(String username) {
        Session session = getSession();
        String query = "from AppliedUsers u WHERE u.owner=:username";
        Query q = session.createQuery(query);
        q.setParameter("username", username);
        if(q.list().size() != 0) {
	        List<AppliedUsers> applicationList = q.list();
	        return applicationList;
        }
        return null;
    }
    
    public ArrayList<Messages> getAllMessages(String username){
    	Session session = getSession();
    	String query = "from Message m WHERE m.owner_name=:username";
    	Query q = session.createQuery(query);
    	q.setParameter("username", username);
    	ArrayList<Messages> msgs = (ArrayList<Messages>) q.getResultList();
    	return msgs;
    }
    
    public void deleteHouse(String id) {
    	Transaction transaction = null;
    	Session session = getSession();
    	
    	System.out.println("OwnerID:" + id);
    	transaction = session.beginTransaction();
    	
    	long rentid = Long.parseLong(id);
    	
    	RentList rentedHouse = session.get(RentList.class, rentid);
    	
    	System.out.println("rent object:"+rentedHouse);
    	System.out.println("Session is:" +session);
    	if(session != null) {
    		session.delete(rentedHouse);
    	}
    	
    	transaction.commit();
    }
    
    public void deleteMessage(String id) {
    	Transaction transaction = null;
    	Session session = getSession();
    	
    	System.out.println("OwnerID:" + id);
    	transaction = session.beginTransaction();
    	
    	long msgid = Long.parseLong(id);
    	
    	Messages msg = session.get(Messages.class, msgid);
    	
    	System.out.println("Message object:"+msg);
    	System.out.println("Session is:" +session);
    	if(session != null) {
    		session.delete(msg);
    	}
    	
    	transaction.commit();
    }
    
    public void approveApplication(String username, long applicationId, long hid) {
    	Transaction transaction = null;
    	Session session = getSession();
    	transaction = session.beginTransaction();
    	System.out.println("user id is:"+hid +"and session is:" +session);
    	RentList rentDetails = session.get(RentList.class, hid);
    	AppliedUsers application = session.get(AppliedUsers.class, applicationId);
    	if(session!=null) {
    		rentDetails.setApprovedId(username);
    		rentDetails.setIsAvailable("false");
    		
    		session.update(rentDetails);
    		session.delete(application);
    		transaction.commit();
    	}
    }
    
    
}