package com.kodeprestige.hibernateConnection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_customer")
	private int id_customer;
	
	@Column(name="first_name")
	private String first_name;
	
	@Column(name="last_name")
	private String last_name;
	
	@Column(name="address")
	private String address;

	
	public Customer() {
	}
	
	public Customer(String firts_name, String last_name, String address) {
		this.first_name = firts_name;
		this.last_name = last_name;
		this.address = address;
	}

	public String getFirts_name() {
		return first_name;
	}

	public void setFirts_name(String firts_name) {
		this.first_name = firts_name;
	}
	

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	

	public int getId_custumer() {
		return id_customer;
	}

	@Override
	public String toString() {
		return "Customer [id_customer=" + id_customer + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", address=" + address + "]";
	}
	
	

}
