package com.bookstore.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.bookstore.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{
	
	List<Book> findAll();
	Book findById(int id);
	

}
