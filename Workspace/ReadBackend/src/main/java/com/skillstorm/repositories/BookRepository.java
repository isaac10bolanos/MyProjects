package com.skillstorm.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer>{

}
