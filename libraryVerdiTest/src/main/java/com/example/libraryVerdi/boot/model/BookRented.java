package com.example.libraryVerdi.boot.model;



import com.example.libraryVerdi.boot.model.Book;

public class BookRented {

		private Book book;
	
			
		public BookRented(Book book) {
			super();
			
			this.book = book;
			
		}

		public Book getBook() {
			return book;
		}

		public void setBook(Book book) {
			this.book = book;
		}
		@Override
		public String toString() {
			return "BookRented [book=" + book + "]";
		}
	}