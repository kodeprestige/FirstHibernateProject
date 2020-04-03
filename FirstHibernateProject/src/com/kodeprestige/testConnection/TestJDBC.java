package com.kodeprestige.testConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {
		

		String jdbJDBC = "jdbc:mysql://localhost:3306/hibernet_schema?useSSL=false&serverTimezone=UTC";
		
		String user = "root";
		
		String password = "mySQLIluEll@713";
		
		try {
			
			System.out.println("Connecting...");
			
			Connection connection = DriverManager.getConnection(jdbJDBC, user, password);
			
			System.out.println("connected: " + connection);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
