package com.finalProject.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import com.finalProject.pojo.RolesModel;

@Service
public class RegisterDao extends dao{

	public void register(RolesModel role) {
		
		Transaction transaction = null;
		
		try(Session session = getSession()){
			
			transaction = session.beginTransaction();
			session.save(role);
			transaction.commit();
		} catch(Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		
	}
	
	public RolesModel checkRoleExists(String username) {
		
		Query q = getSession().createQuery("FROM RoleDB u WHERE u.username=:username");
		q.setParameter("username", username);
		return (RolesModel)q.uniqueResult();
		
	}
}
