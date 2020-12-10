package com.example.libraryVerdi.boot.model;

import java.sql.Date;
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
public class Reservations {
	
	 	  
	  @Id
		@GeneratedValue(strategy = GenerationType.AUTO)
	  @Column(name = "ID")
		private Long id;
	  @Column(name = "DATE")
		private String date;
	  @Column(name = "STATUS")
		private String status;
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "BOOK_ID_FK", nullable = true)
		@JsonIgnore
		private Book book;
		
		
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "CUSTOMER_ID_FK", nullable = true)
		@JsonIgnore
		private Customer customer;
		
		
		

		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}

		public Reservations (Long id, String status, String date, Book book) { 
			this.id=id;
			this.status= status;
			this.date=date;
			this.book=book;
			
			
		}
		
		public Reservations() {}

		@Override
		public String toString() {
			return "Reservations [id=" + id + ", date=" + date + ", status=" + status + ", book=" + book + "]";
		}

		/**
		 * @return the id
		 */
		public Long getId() {
			return id;
		}

		/**
		 * @param id the id to set
		 */
		public void setId(Long id) {
			this.id = id;
		}

		/**
		 * @return the date
		 */
		public String getDate() {
			return date;
		}

		/**
		 * @param date the date to set
		 */
		public void setDate(String date) {
			this.date = date;
		}

		/**
		 * @return the status
		 */
		public String getStatus() {
			return status;
		}

		/**
		 * @param status the status to set
		 */
		public void setStatus(String status) {
			this.status = status;
		}

		/**
		 * @return the book
		 */
		public Book getBook() {
			return book;
		}

		/**
		 * @param book the book to set
		 */
		public void setBook(Book book) {
			this.book = book;
		}
		
}