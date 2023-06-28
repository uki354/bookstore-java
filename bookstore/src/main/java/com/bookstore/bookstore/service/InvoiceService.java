package com.bookstore.bookstore.service;

import java.util.List;

import com.bookstore.bookstore.model.Invoice;

public interface InvoiceService {
	
	void saveInvoice(Invoice invoice);
	List<Invoice> findAllByUser();

}
