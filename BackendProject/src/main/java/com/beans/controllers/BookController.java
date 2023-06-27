package com.beans.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beans.models.Book;
import com.beans.repositories.BookRepository;

@RestController
@RequestMapping("/book")
@CrossOrigin("*")
public class BookController {
	
	@Autowired
	private BookRepository repo;
	
	@GetMapping
	public Iterable<Book> getAllBooks(){
		return repo.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Book> addBook(@RequestBody Book book){
		if(repo.existsById(book.getBookId())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(book);
		} else {
			return ResponseEntity.status(HttpStatus.CREATED).body(repo.save(book));
		}
	}

}
