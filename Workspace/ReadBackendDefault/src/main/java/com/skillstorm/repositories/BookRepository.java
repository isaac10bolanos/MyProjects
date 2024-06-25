package com.skillstorm.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.models.Book;

// we need this to designate this interface as a Repository team
// this allows it to be injected elsewhere
// this repository automatically generates all the CRUD operations we'll need for this specific table
@Repository
public interface BookRepository extends CrudRepository<Book, Integer>{

}
