package com.learn.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.learn.hibernate.entity.Student;

public class DeleteTest {
public static void main(String[] args)
{
   SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
   Session session=factory.getCurrentSession();
	session.beginTransaction();
	/*
	 * Query q=session.createQuery("delete from Student where id= :id");
	 * q.setParameter("id", 3); q.executeUpdate();
	 */
	Student std=session.get(Student.class, 2);
	session.delete(std);
	session.getTransaction().commit();
}
}
