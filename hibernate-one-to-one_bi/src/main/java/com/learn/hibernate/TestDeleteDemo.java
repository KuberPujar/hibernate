package com.learn.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learn.hibernate.entity.Instructor;
import com.learn.hibernate.entity.InstructorDetails;

public class TestDeleteDemo {
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try
		{
			session.beginTransaction();
			Instructor instructor=session.get(Instructor.class, 1);
			session.delete(instructor);
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}
}
