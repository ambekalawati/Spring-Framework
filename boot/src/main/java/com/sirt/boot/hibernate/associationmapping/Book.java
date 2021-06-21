package com.sirt.boot.hibernate.associationmapping;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "book")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "book_id")
	private int bookId;
	@Column(name = "book_name")
	private String bookName;
	@Column(name = "price")
	private double price;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_book")
	private List<Review> reviews = new ArrayList<>();

	public Book(String bookName, double price) {
		super();
		this.bookName = bookName;
		this.price = price;
	}

}
