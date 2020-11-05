package com.learn.hibernate;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learn.hibernate.entity.Course;
import com.learn.hibernate.entity.Instructor;
import com.learn.hibernate.entity.InstructorDetails;
import com.learn.hibernate.entity.Student;

public class TestCreateDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try
		{
			session.beginTransaction();
			
			//Instructor instructor=new Instructor("Kuber", "Pujar", "kp@gmail.com");
			//InstructorDetails instrDtls=new InstructorDetails("https://youtube.com/kp", "coding");
			//Course c2=new Course("SpringBoot");
			//instructor.setInstructorDtls(instrDtls);
			//instructor.setCourses(Arrays.asList(c2));
			//Instructor instr=session.get(Instructor.class, 4);
			//instr.addCourse(c2);
			//session.save(c2);
			
			//Instructor tempInst=session.get(Instructor.class, 3);
			//InstructorDetails instDtls1=new InstructorDetails("https://youtube.com/kk", "teaching");
			Course course=new Course("Maths");
			//tempInst.setInstructorDtls(instDtls1);
			//tempInst.setCourses(Arrays.asList(course));
			Instructor inst=session.get(Instructor.class, 3);
			inst.addCourse(course);
			session.save(course);
			session.getTransaction().commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
