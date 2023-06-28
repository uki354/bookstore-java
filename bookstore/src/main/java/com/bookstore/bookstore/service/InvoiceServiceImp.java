package com.bookstore.bookstore.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bookstore.bookstore.model.Invoice;
import com.bookstore.bookstore.repository.InvoiceRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImp implements InvoiceService {
	
	private final InvoiceRepository invoiceRepository;
	private final UserService userService;
	
	@Override
	public void saveInvoice(Invoice invoice) {
		invoice.setIssuedAt(LocalDateTime.now());
		invoice.setUser(userService.getAuthenticatedUser());
		invoiceRepository.save(invoice);
	}

	@Override
	public List<Invoice> findAllByUser() {
		return invoiceRepository.findAllByUser(userService.getAuthenticatedUser());
	}
	
	
	

}
