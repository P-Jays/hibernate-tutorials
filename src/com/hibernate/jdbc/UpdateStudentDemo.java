package com.hibernate.jdbc;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.jdbc.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try {
		
			int numId = 10;
			
			session.beginTransaction();
		
			Student student9 = session.get(Student.class, numId);
			
			student9.setFirstName("PJ");
			
			session.getTransaction().commit();
			
			System.out.println(student9);
			
			//============================//
			
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			session.createQuery("update Student set email='@mmd.com'").executeUpdate();
			
			List<Student> listStdnt = session.createQuery("from Student").getResultList();
			
			for(Student tempStudent : listStdnt) {
				
				System.out.println(tempStudent);
				
			}
			
			session.getTransaction().commit();
			
			
		}
		finally {
			factory.close();
		}
		
	}

}
