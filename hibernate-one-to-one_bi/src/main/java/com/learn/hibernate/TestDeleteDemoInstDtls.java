package com.learn.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learn.hibernate.entity.Instructor;
import com.learn.hibernate.entity.InstructorDetails;

public class TestDeleteDemoInstDtls {
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try
		{
			session.beginTransaction();
			InstructorDetails instructorDtls=session.get(InstructorDetails.class, 2);
			instructorDtls.getInstructor().setInstructorDtls(null);
			session.delete(instructorDtls);
			session.getTransaction().commit();
		}
		finally {
			session.close();
			factory.close();
		}
	}
}
