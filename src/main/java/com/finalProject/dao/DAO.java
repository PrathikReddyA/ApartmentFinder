package com.finalProject.dao;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
@org.springframework.context.annotation.Configuration
public class dao {
	
	private static final Logger log = Logger.getAnonymousLogger();
    
	private static final ThreadLocal sessionThread = new ThreadLocal();
    private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    protected dao() {
    }

    public static Session getSession()
    {
        Session session = (Session) dao.sessionThread.get();
        
        if (session == null)
        {
            session = sessionFactory.openSession();
            dao.sessionThread.set(session);
        }
        return session;
    }

    protected void begin() {
        getSession().beginTransaction();
    }
    
    

    protected void commit() {
        getSession().getTransaction().commit();
    }

    protected void rollback() {
        try {
            getSession().getTransaction().rollback();
        } catch (HibernateException e) {
            log.log(Level.WARNING, "Cannot rollback", e);
        }
        try {
            getSession().close();
        } catch (HibernateException e) {
            log.log(Level.WARNING, "Cannot close", e);
        }
        dao.sessionThread.set(null);
    }

    public static void close() {
        getSession().close();
        dao.sessionThread.set(null);
    }
}