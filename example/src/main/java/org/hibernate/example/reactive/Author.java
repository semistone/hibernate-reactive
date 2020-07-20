package org.hibernate.example.reactive;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.PERSIST;

@Entity
@Table(name="authors")
class Author {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@NotNull @Size(max=100)
	String name;

	@OneToMany(mappedBy = "author", cascade = PERSIST)
	List<Book> books = new ArrayList<>();

	Author(String name) {
		this.name = name;
	}

	Author() {}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
}
