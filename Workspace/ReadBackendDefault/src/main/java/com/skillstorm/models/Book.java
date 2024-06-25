package com.skillstorm.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// we need properties for each field in the database table, regular Java naming conventions
// we need a no-args constructor AND an argumented constructor
// we need getters, setters, full encapsulation, etc.
// toString() optional, useful for debugging

// this annotation states that this class corresponds to a database table record
@Entity
// this one tells it which table it corresponds to
@Table(name = "book")
public class Book {
	
	// Id tells us this is a primary key
	// GeneratedValue tells us the database must generate this and how
	// Column tells us which database column this variable goes with
	// order does not matter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id")
	private int bookId;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "author")
	private String author;
	
	@Column(name = "genre")
	private String genre;
	
	@Column(name = "publisher")
	private String publisher;
	
	@Column(name = "book_count")
	private int bookCount;
	
	public Book() {}

	public Book(int bookId, String title, String author, String genre, String publisher, int bookCount) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.publisher = publisher;
		this.bookCount = bookCount;
	}

	public int getBookId() {
		return this.bookId;
	}

	public void setBookId(int albumId) {
		this.bookId = albumId;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String artist) {
		this.author = artist;
	}

	public String getGenre() {
		return this.genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPublisher() {
		return this.publisher;
	}

	public void setPublisher(String label) {
		this.publisher = label;
	}

	public int getBookCount() {
		return this.bookCount;
	}

	public void setBookCount(int trackCount) {
		this.bookCount = trackCount;
	}

	@Override
	public String toString() {
		return "Album [albumId=" + this.bookId + ", title=" + this.title + ", artist=" + this.author + ", genre=" + this.genre + ", label="
				+ this.publisher + ", trackCount=" + this.bookCount + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return bookId == other.bookId && Objects.equals(author, other.author) && Objects.equals(genre, other.genre)
				&& Objects.equals(publisher, other.publisher) && Objects.equals(title, other.title)
				&& bookCount == other.bookCount;
	}
	
	
	
	
	
	

}
