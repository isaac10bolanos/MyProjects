package com.skillstorm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.models.Book;
import com.skillstorm.repositories.BookRepository;

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
	public ResponseEntity<Book> addArtist(@RequestBody Book book){
		// if the record with that id already exist, don't overwrite it
		if(repo.existsById(book.getBookId())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(book);
			// if it doesn't add a new one
		} else {
			
			return ResponseEntity.status(HttpStatus.CREATED).body(repo.save(book));
		}
	}

}
