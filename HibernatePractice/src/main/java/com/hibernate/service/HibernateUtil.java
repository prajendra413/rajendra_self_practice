package com.hibernate.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	public static SessionFactory getSessionFactory()
	{
		if(sessionFactory == null)
		{
			sessionFactory = new Configuration().configure().buildSessionFactory();
			return sessionFactory;
		}
		return sessionFactory;
	}
	
	public static void shutDown()
	{
		getSessionFactory().close();
	}
	
	public static Session getSession()
	{
		return getSessionFactory().openSession();
	}
	
	
	public static void closeSession(Session session)
	{
		session.close();
	}
}
