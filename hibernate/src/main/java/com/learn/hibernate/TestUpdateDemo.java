package com.learn.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learn.hibernate.entity.Student;

public class TestUpdateDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		int id = 1;
		Student std = session.get(Student.class, id);
		std.setFirstName("Putty");
		session.createQuery("update Student s set s.email='foo@gmail.com'").executeUpdate();
		session.getTransaction().commit();
		
	}

}
