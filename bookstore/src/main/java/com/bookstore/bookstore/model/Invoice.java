package com.bookstore.bookstore.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Invoice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToMany
	@JoinTable(name = "book_invoice",
    joinColumns        = @JoinColumn(name = "book_id"),
    inverseJoinColumns = @JoinColumn(name = "invoice_id"))	
	private List<Book> books;
	private double totalPrice;
	@Column(name = "issued_at")
	private LocalDateTime issuedAt;
	@ManyToOne
	private UserModel user;
}
