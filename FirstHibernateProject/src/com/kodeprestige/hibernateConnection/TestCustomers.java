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
			
			Customers customer = new Customers("elaitch", "prestige", "Miami, FL");
			
			//Execute transaction
			session.beginTransaction();
			session.save(customer);
			session.getTransaction().commit();
			
			System.out.println("Customer    " + customer + "   inserted.");
			
			
			//Read register
			session.beginTransaction();
			int id_custumer = customer.getId_custumer();
			
			System.out.println("id_custumer: "+ id_custumer);
			
			Customers insertedCustomer = session.get(Customers.class, id_custumer);
			
			System.out.println("Inserted Customer:" + insertedCustomer);
			
			session.getTransaction().commit();
			
			System.out.println("Done...");
			
			
			
		} finally {
			session.close();
			factory.close();
		}

	}

}
