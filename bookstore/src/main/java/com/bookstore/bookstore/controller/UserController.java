package com.bookstore.bookstore.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.bookstore.model.Invoice;
import com.bookstore.bookstore.model.UserModel;
import com.bookstore.bookstore.service.InvoiceService;
import com.bookstore.bookstore.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
	
	private final UserService userService;
	private final InvoiceService invoiceService;
	
	@PostMapping("/signup")
	public UserModel signup(@RequestBody UserModel user) {
		return userService.createUser(user);
	}
	
	@GetMapping("/get")
	public UserModel getUser() {
		return userService.getAuthenticatedUser();
	}
	
	@PostMapping("/update")
	public void updateUser(@RequestBody UserModel user ) {
		 userService.updateUser(user);
	}
	
	@GetMapping("/getInvoices")
	public List<Invoice> getInvoices(){
		return invoiceService.findAllByUser();
	}

}
