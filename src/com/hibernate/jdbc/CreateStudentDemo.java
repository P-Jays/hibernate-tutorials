package com.hibernate.jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.jdbc.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try {
		
			System.out.println("Creating new object.. ");
			Student tempStudent1 = new Student("Maikel","Hosse","Mhones@gmail.com");
			Student tempStudent2 = new Student("Miyuki","Barbr","mmamaia@gmail.com");
			Student tempStudent3 = new Student("Michello","Pradad","Mutang@gmail.com");
					
			
			session.beginTransaction();
			
			System.out.println("saving the student");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
			
			System.out.println("done");
			
			session.getTransaction().commit();
			
			
			
		}
		finally {
			factory.close();
		}
		
	}

}
