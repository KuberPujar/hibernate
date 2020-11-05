package com.learn.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.learn.hibernate.entity.Student;
import com.learn.hibernate.utils.DateUtils;

public class TestJDBC {

	
	public static void main(String[] args) {
		/*
		 * String dbUrl="jdbc:postgresql://localhost:5432/kuber"; String
		 * username="kuber"; String password="P@$$w0rd";
		 */
		
		SessionFactory sessionFactory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		Session session=sessionFactory.getCurrentSession();
		try {
			/*
			 * System.out.println("connecting to database usrl:"+dbUrl); Connection
			 * myConn=DriverManager.getConnection(dbUrl, username, password);
			 * System.out.println("connection successful!!!!");
			 */
			String dob="23/01/1989";
			Date date=DateUtils.parseDate(dob);
					
			/*
			 * Student std1=new Student("kavitha", "Kuber", "kavithakuber@gmail.com",date);
			 * session.beginTransaction(); session.save(std1);
			 */
			session.beginTransaction();
			Student std=session.get(Student.class, 1);
			std.setDateOfBirth(date);
			 session.getTransaction().commit();
			 
			//Student std=session.get(Student.class, 1);
			//System.out.println("fname:"+std.getFirstName()+" lastName:"+std.getLastName()+" email:"+std.getEmail());
			/*
			 * session.beginTransaction(); List<Student>
			 * allStd=session.createQuery("from Student").getResultList(); for(Student
			 * st:allStd) {
			 * System.out.println("fname:"+st.getFirstName()+" lastName:"+st.getLastName()
			 * +" email:"+st.getEmail()); }
			 * 
			 * allStd=session.createQuery("from Student s where s.lastName='Pujar'").
			 * getResultList(); for(Student st:allStd) {
			 * System.out.println("fname:"+st.getFirstName()+" lastName:"+st.getLastName()
			 * +" email:"+st.getEmail()); }
			 */
			
		}
		catch(Exception exe)
		{
			exe.printStackTrace();
		}
		finally {
			sessionFactory.close();
		}
	}

}
