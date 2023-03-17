package com.finalProject.dao;


import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import com.finalProject.pojo.RolesModel;

@Service
public class LoginDao extends dao{
	
	public RolesModel get(long id) {
		return getSession().get(RolesModel.class, id);
	}
	
	public RolesModel getUserLogin(String username, String password){
		Query q = getSession().createQuery("FROM RoleDB u WHERE u.username=:username AND u.password=:password AND u.role='user'");
		q.setParameter("username", username);
		q.setParameter("password", password);
		return (RolesModel)q.uniqueResult();
	}
	
	public RolesModel getOwnerLogin(String username, String password){
		Query q = getSession().createQuery("FROM RoleDB u WHERE u.username=:username AND u.password=:password AND u.role='owner'");
		q.setParameter("username", username);
		q.setParameter("password", password);
		return (RolesModel)q.uniqueResult();
	}
	
	public RolesModel getAdminLogin(String username, String password){
		Query q = getSession().createQuery("FROM RoleDB u WHERE u.username=:username AND u.password=:password AND u.role='admin'");
		q.setParameter("username", username);
		q.setParameter("password", password);
		return (RolesModel)q.uniqueResult();
	}
	

		
	
}
 