package com.example.libraryVerdi.boot.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Customer {
	// ...
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CUSTOMER_ID")
	private Long customer_id;
	@Column(name = "FIRSTNAME")
	private String firstName;
	@Column(name = "LASTNAME")
	private String lastName;
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Reservations> reservations;
	

public Customer() {}

public Customer(String firstName, String lastName) {
	this.firstName = firstName;
	this.lastName = lastName;
}

public Long getId() {
	return customer_id;
}

public void setId(Long customer_id) {
	this.customer_id = customer_id;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}



public List<Reservations> getReservations() {
	return reservations;
}

public void setReservations(List<Reservations> reservations) {
	this.reservations = reservations;
}

@Override
public String toString() {
	return "Customer [id=" + customer_id + ", firstName=" + firstName + ", lastName=" + lastName + ", reservations="
			+ reservations + "]";
}}
	
	