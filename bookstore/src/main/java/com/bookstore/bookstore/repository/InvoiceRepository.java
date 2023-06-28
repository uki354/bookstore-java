package com.bookstore.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.bookstore.model.Invoice;
import com.bookstore.bookstore.model.UserModel;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer>{
	
	List<Invoice> findAllByUser(UserModel user);

}
