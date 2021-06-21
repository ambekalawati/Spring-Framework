package com.sirt.boot.hibernate.associationmapping;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "author")
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "author_id")
	private int authorId;
	@Column(name = "author_name")
	private String authorName;
	@ManyToMany(mappedBy = "authors", cascade = CascadeType.ALL)
	private List<MyBook> books = new ArrayList<>();

	public void addBook(MyBook book) {
		this.books.add(book);
		book.getAuthors().add(this);
	}

	public void removeBook(MyBook book) {
		this.books.remove(book);
		book.getAuthors().remove(this);
	}

}
