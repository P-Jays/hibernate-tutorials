package com.hibernate.jdbc;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.jdbc.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try {
		
			
			session.beginTransaction();
			
			List<Student> tempStudent = session.createQuery("from Student").getResultList();
			
			for(Student theseStudents : tempStudent) {
				System.out.println(theseStudents);
			}
			
			System.out.println("\nWhere last name is Prajnawi");
			
			tempStudent = session.createQuery("from Student s where s.lastName ='Prajnawi'").getResultList();
			
			
			for(Student theseStudents : tempStudent) {
				System.out.println(theseStudents);
			}
			
			System.out.println("\nWhere last name is Prajnawi or First Name is Michelle");
			
			tempStudent = session.createQuery("from Student s where s.lastName ='Prajnawi'"
					+ " or s.firstName='Michelle'").getResultList();
			
			
			for(Student theseStudents : tempStudent) {
				System.out.println(theseStudents);
			}
			
			System.out.println("\nWhere email is @gmail.com");
			
			tempStudent = session.createQuery("from Student s where s.email like '%@gmail.com'").getResultList();
			
			
			for(Student theseStudents : tempStudent) {
				System.out.println(theseStudents);
			}
			
			
			session.getTransaction().commit();
			
			
			
		}
		finally {
			factory.close();
		}
		
	}

}
