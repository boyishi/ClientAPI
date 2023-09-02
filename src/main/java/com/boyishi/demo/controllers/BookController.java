package com.boyishi.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.boyishi.demo.entities.Book;
import com.boyishi.demo.services.BookService;

@SuppressWarnings("unused")
@Controller
public class BookController {
	private final BookService bookService;
	
	@Autowired
	public BookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}
	
	// Get
	@GetMapping(value = "/books")
	@ResponseBody
	public List<Book> get(){
		return bookService.get();
	}
	
	// Add
	@PostMapping(value = "/books")
	public String post(@ModelAttribute Book params) {
		bookService.post(params);
		return "redirect:/";
	}
	
	// Get by ID
	@DeleteMapping(value="/users/{bookId}")
	@ResponseBody
	public String delete(@PathVariable int bookId) {
		return bookService.delete(bookId);
	}
	
	@PutMapping(value="/users/{bookId}")
	@ResponseBody
	public Book update(@PathVariable long bookId, @RequestBody Book params) {
		return bookService.update(params, bookId);
	}
}