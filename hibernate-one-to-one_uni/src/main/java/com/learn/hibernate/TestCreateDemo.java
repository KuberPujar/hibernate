package com.learn.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learn.hibernate.entity.Instructor;
import com.learn.hibernate.entity.InstructorDetails;
import com.learn.hibernate.entity.Student;

public class TestCreateDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try
		{
			session.beginTransaction();
			Instructor instructor=new Instructor("Kavitha", "kuber", "kk@gmail.com");
			InstructorDetails instrDtls=new InstructorDetails("https://youtube.com/kk", "teaching");
			instructor.setInstructorDtls(instrDtls);
			session.save(instructor);
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}

}
