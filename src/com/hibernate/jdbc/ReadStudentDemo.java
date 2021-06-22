package com.hibernate.jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.jdbc.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try {
		
			System.out.println("Creating new object.. ");
		
			Student tempStudent3 = new Student("Michelle","Prajnawi","Mutang@gmail.com");
					
			
			session.beginTransaction();
			
			System.out.println("saving the student");
			
			session.save(tempStudent3);
			
			
			System.out.println("done");
			
			session.getTransaction().commit();
			
			//==========================
			
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			System.out.println("get the studentID"+tempStudent3.getId());
			
			Student myStudent = session.get(Student.class, tempStudent3.getId());
			
			System.out.println(myStudent);
			
			session.getTransaction().commit();;
			
			
			
			
			
			
		}
		finally {
			factory.close();
		}
		
	}

}
