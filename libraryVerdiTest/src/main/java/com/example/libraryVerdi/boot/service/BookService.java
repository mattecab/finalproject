package com.example.libraryVerdi.boot.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.libraryVerdi.boot.model.Book;
import com.example.libraryVerdi.boot.model.Reservations;
import com.example.libraryVerdi.boot.repository.BookRepository;
import com.example.libraryVerdi.boot.utils.StatusSession;


@Service
public class BookService {

	@Autowired
	BookRepository repository;
	
	
	public Iterable<Book> findAll() {
		
		return repository.findAll();
	}
	
	public void insertBook(Book book) {
		
		repository.save(book);
	}
	public void insertStatus(Book book) {

		repository.save(book);
	}
	public void remove(Book book) {
		
		repository.delete(book);
	}

	public Book findById(long id) {

		return repository.findById(id);
	

}}