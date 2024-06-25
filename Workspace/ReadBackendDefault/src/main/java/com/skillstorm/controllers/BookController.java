package com.skillstorm.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.models.Book;
import com.skillstorm.repositories.BookRepository;

// this class is the front line for communication into and out of your API
// HTTP requests come in from the front end, HTTP Responses are sent back to the front end

// this states that this class is a controller AND that all outgoing communication is wrapped in an HTTPResonseBody
@RestController
// this states that all incoming requests with our base URL and this suffix will go to this controller
@RequestMapping("/book")
// this restricts incoming traffic to the sources designated, in this case, * = everywhere
@CrossOrigin("*")
public class BookController {
	
	// this injects our corresponding repo wherever we need it, can be private we're only using it here
	@Autowired
	private BookRepository repo;
	
	
	@GetMapping
	public Iterable<Book> getAllBooks() {
		return repo.findAll();
	}
	
	@GetMapping("/{id}")
	public Book getBookById(@PathVariable int id) {
		Optional<Book> result = repo.findById(id);
		if(result.isPresent()) {
			return result.get();
		} else {
			return null;
		}
	}

	
	@PostMapping
	public ResponseEntity<String> addAlbum(@RequestBody Book book){
		if(repo.existsById(book.getBookId())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Book with id " + book.getBookId() + " already exist!");
		} else {
			return ResponseEntity.status(HttpStatus.CREATED).body("Book with id " + repo.save(book).getBookId() + " has been inserted.");
		}
	}
	
	@PostMapping("/multiple")
	public ResponseEntity<List<ArrayList<Integer>>> addMultipleBooks(@RequestBody Book[] books){
		if(books == null || books.length == 0) {
			return ResponseEntity.status(400).body(null);
		}
		
		List<ArrayList<Integer>> temp = new ArrayList<>();
		temp.add(new ArrayList<>());
		temp.add(new ArrayList<>());
		
		for(Book book : books) {
			if(repo.findById(book.getBookId()).isPresent()) {
				temp.get(1).add(book.getBookId());
			} else {
				temp.get(0).add(repo.save(book).getBookId());
			}
		}
		
		return ResponseEntity.status(200).body(temp);
	}
	
	@DeleteMapping("/delmultiple")
	public ResponseEntity<List<ArrayList<Integer>>> deleteMultipleBooks(@RequestBody Book[] books){
		if(books == null || books.length == 0) {
			return ResponseEntity.status(400).body(null);
		}
		
		List<ArrayList<Integer>> temp = new ArrayList<>();
		temp.add(new ArrayList<>());
		temp.add(new ArrayList<>());
		
		for(Book book : books) {
			if(repo.findById(book.getBookId()).isPresent()) {
				temp.get(0).add(book.getBookId());
				repo.delete(book);
			} else {
				temp.get(1).add(book.getBookId());
			} 
		}
		
		return ResponseEntity.status(200).body(temp);
	}
	
	

	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateBook(@PathVariable int id,
											 @RequestParam(name = "title", required = false)String title,
											 @RequestParam(name = "author", required = false)String author,
											 @RequestParam(name = "genre", required = false)String genre,
											 @RequestParam(name = "publisher", required = false)String publisher,
											 @RequestParam(name = "bookCount", required = false)String bookCount){
		if(repo.findById(id).isPresent()) {
			Book temp = repo.findById(id).get();
			
			if(title != null) {
				temp.setTitle(title);
			}
			if(author != null) {
				temp.setAuthor(author);
			}
			if(genre != null) {
				temp.setGenre(genre);
			}
			if(publisher != null) {
				temp.setPublisher(publisher);
			}
			if(bookCount != null) {
				temp.setBookCount(Integer.valueOf(bookCount));
			}
		return ResponseEntity.status(HttpStatus.OK).body("Book with id " + repo.save(temp).getBookId() + " has been updated.");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Book with id " + id + " already exist!");
		
	}
	
	
	// an endpoint for deleting a specific album via its ID
	// same PathVariable system as our getAlbumById method
//	@DeleteMapping("/{id}")
//	// the deleteById repo method returns void, so we use a 204 (No Content) status and don't need a return type
//	@ResponseStatus(code = HttpStatus.NO_CONTENT)
//	public void deleteAlbum(@PathVariable int id) {
//		repo.deleteById(id);
//	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteBookByPathId(@PathVariable int id){
		if(repo.existsById(id)) {
			repo.deleteById(id);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Book with id of " + id + " was successfully deleted.");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Book with id of " + id + " does not exist!");
		}
	}
	

	
	@DeleteMapping
	public ResponseEntity<String> deleteBookByBodyContent(@RequestBody Book book){
		if(repo.findById(book.getBookId()).isPresent() &&
			book.equals(repo.findById(book.getBookId()).get())){
				repo.delete(book);
				return ResponseEntity.status(HttpStatus.ACCEPTED).body("Book sent was successfully deleted.");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Book sent does not exist!");
		}
		
	} 
	
	
	
	

}
