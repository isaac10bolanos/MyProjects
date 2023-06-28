package com.beans.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.beans.models.Book;

public interface BookRepository extends CrudRepository<Book, Integer>{
	
	@Query (value = "SELECT * FROM book WHERE title = 'The Great Gatsby'", nativeQuery = true)
	public Iterable<Book> findGreat(String searchGreat);

}
