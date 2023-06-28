package com.bookstore.bookstore.service;

import java.util.List;

import com.bookstore.bookstore.model.Book;

public interface BookService {
	
	List<Book> getAllBooks();
	Book getBook(int id);
	
}
