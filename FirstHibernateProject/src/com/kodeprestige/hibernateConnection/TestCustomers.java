package com.kodeprestige.hibernateConnection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestCustomers {

	public static void main(String[] args) {
		
		
		//Create SessionFactory
		SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
											.addAnnotatedClass(Customers.class)
												.buildSessionFactory();
		
		//Create Session
		Session session = factory.openSession();
		
		//Create Customers object
		try {
			
			Customers customer = new Customers("Hector", "Ortega", "Holland, MI");
			
			//Execute transaction
			session.beginTransaction();
			
			session.save(customer);
			
			session.getTransaction().commit();
			
			System.out.println("Customer    " + customer + "   inserted.");
			
			
			
		} finally {
			session.close();
			factory.close();
		}

	}

}
