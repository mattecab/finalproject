package com.example.libraryVerdi.boot.repository;




import org.springframework.data.repository.CrudRepository;

import com.example.libraryVerdi.boot.model.Book;


public interface BookRepository extends CrudRepository<Book, Long> {


	Book findById(long id);
	

}



