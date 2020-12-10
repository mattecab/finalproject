package com.example.libraryVerdi.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.libraryVerdi.boot.service.BookService;
import com.example.libraryVerdi.boot.model.Book;



	@RestController
	@RequestMapping("/webapi")
	public class BookRestController {

		@Autowired
		BookService service;
		
		
		@GetMapping("/books")
		public Iterable<Book> findAll() {

			return service.findAll();
		}
	}