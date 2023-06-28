package com.bookstore.bookstore.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.bookstore.model.Book;
import com.bookstore.bookstore.model.Invoice;
import com.bookstore.bookstore.service.BookService;
import com.bookstore.bookstore.service.InvoiceService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/book")
public class BookController {
	
	private final BookService bookService;
	private final InvoiceService invoiceService;
	
	@GetMapping("/getAll")
	public List<Book> getAllBooks(){
		return bookService.getAllBooks();		
	}
	
	@GetMapping("/get/{id}")
	public Book getBook(@PathVariable int id) {
		return bookService.getBook(id);
	}

	
	@PostMapping("/buy")
	public void buyBook(@RequestBody Invoice invoice) {
		invoiceService.saveInvoice(invoice);
	}
}
