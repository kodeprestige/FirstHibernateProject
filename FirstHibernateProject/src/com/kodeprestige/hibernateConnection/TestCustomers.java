package com.kodeprestige.hibernateConnection;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestCustomers {
	
	public static void main(String[] args) {
		
		
		//Create SessionFactory
		SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
											.addAnnotatedClass(Customer.class)
												.buildSessionFactory();
		
		//Create Session
		Session session = factory.openSession();
		
		try {
			
			//Begin transaction
			session.beginTransaction();
			
			//Create Customer object
			Customer customer = new Customer("Loyda", "Ortega", "Miami, FL");
			
		//Execute transaction
			session.save(customer);
			
			System.out.println("Customer:   " + customer + "   inserted.");
			
			
			System.out.println();
			
			
			//Read register
			int id_custumer = customer.getId_custumer();
			
			System.out.println("id_custumer: "+ id_custumer);
			
			Customer insertedCustomer = session.get(Customer.class, id_custumer);
			
			System.out.println("Inserted Customer:  " + insertedCustomer);
			
			
			System.out.println();
			
			
		//Select Query
			
			
			//Select all customers
			 showAllCustomer(session);
			
			//Select all customers named Hector who lives in Tampa, FL
			@SuppressWarnings("unchecked")
			List<Customer> customers = session
							.createQuery("FROM Customer cl "
									+ "WHERE cl.first_name='Hector' "
									+ "AND cl.address='Tampa, FL'")
								.getResultList();
			System.out.println("Show all customers named Hector who lives in Tampa, FL");
			showCustomers(customers);
			
			System.out.println();
			
		//Update
			
			//Way 1:
			insertedCustomer.setFirts_name("Loydita");
			
			//Way 2:
			session.createQuery("UPDATE Customer set first_name='Hectico' WHERE first_name LIKE 'H%'").executeUpdate();
			
		//Delete
			session.createQuery("DELETE Customer WHERE address LIKE 'Miami%'").executeUpdate();
			
			showAllCustomer(session);
			
			
		//Commit
			session.getTransaction().commit();
			
			
		} finally {
			session.close();
			factory.close();
		}

	}

	private static void showAllCustomer(Session session) {
		
		 @SuppressWarnings("unchecked")
		 List<Customer> customers= session.createQuery("FROM Customer").getResultList();
		 
		 System.out.println("Show all clients");
		 showCustomers(customers);
		 System.out.println();
	}

	private static void showCustomers(List<Customer> customers) {
		for(Customer selectCustomer:customers) {
			System.out.println(selectCustomer);
		}
	}

}
