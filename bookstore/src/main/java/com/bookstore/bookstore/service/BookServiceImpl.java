package com.bookstore.bookstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bookstore.bookstore.model.Book;
import com.bookstore.bookstore.repository.BookRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookServiceImpl  implements BookService {
	
	private final BookRepository bookRepository;
	
	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();		
	}

	@Override
	public Book getBook(int id) {
		return bookRepository.findById(id);
	}
	
	
	
	

}
