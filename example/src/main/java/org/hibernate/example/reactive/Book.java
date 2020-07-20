package org.hibernate.example.reactive;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name="books")
class Book {
	@Id @GeneratedValue
	Long id;

	@NotNull @Size(min=13, max=13)
	@Basic(fetch = LAZY)
	String isbn;

	public String getIsbn() {
		return isbn;
	}

	@NotNull @Size(max=100)
	String title;

	@NotNull @ManyToOne(fetch = LAZY)
	Author author;

	Book(String isbn, String title, Author author) {
		this.title = title;
		this.isbn = isbn;
		this.author = author;
	}

	Book() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
}
