package com.finalProject.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.finalProject.pojo.RolesModel;

@Service
@Component
public class AdminDao extends dao{

	public List<RolesModel> getAllOwners() {
		Session session = getSession();
        String query = "from RoleDB r WHERE r.role='owner'";
        Query q = session.createQuery(query);
        if(q.list().size() != 0) {
	        List<RolesModel> ownerlist = q.list();
	        return ownerlist;
        }
        return null;

	}

	public void removeOwner(String id) {
    	Transaction transaction = null;
    	Session session = getSession();
    	
    	System.out.println("OwnerID:" + id);
    	transaction = session.beginTransaction();
    	
    	long ownerid = Long.parseLong(id);
    	
    	RolesModel ownerObj = session.get(RolesModel.class, ownerid);
    	
    	System.out.println("Owner object:"+ownerObj);
    	System.out.println("Session is:" +session);
    	
    	if(session != null) {
    		session.delete(ownerObj);
    	}
    	
    	transaction.commit();
    }

	public List<RolesModel> getAllUsers() {
		
		Session session = getSession();
        String query = "from RoleDB r WHERE r.role='user'";
        Query q = session.createQuery(query);
        if(q.list().size() != 0) {
	        List<RolesModel> userlist = q.list();
	        return userlist;
        }
        return null;
		
	}

	
	
}
