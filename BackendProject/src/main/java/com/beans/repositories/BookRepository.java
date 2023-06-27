package com.beans.repositories;

import org.springframework.data.repository.CrudRepository;

import com.beans.models.Book;

public interface BookRepository extends CrudRepository<Book, Integer>{

}
