package com.boyishi.demo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boyishi.demo.entities.Book;
import com.boyishi.demo.repositories.BookRepository;
import com.boyishi.demo.services.BookService;

@Service
public class BookServiceImpl implements BookService {
	private final BookRepository bookRepo;
	
	@Autowired
	public BookServiceImpl(BookRepository bookRepo) {
		super();
		this.bookRepo = bookRepo;
	}

	@Override
	public Book post(Book params) {
		bookRepo.save(params);
		return params;
	}

	@Override
	public List<Book> get() {
		return bookRepo.findAll();
	}

	@Override
	public Book get(long bookId) {
		return bookRepo.findById(bookId).get();
	}

	@Override
	public Book update(Book params, long bookId) {
		Book book = bookRepo.findById(bookId).get();
		book.setAuthor(params.getAuthor());
		book.setTitle(params.getTitle());
		
		return bookRepo.save(book);
	}

	@Override
	public String delete(long bookId) {
		bookRepo.deleteById(bookId);
		return "User(" + bookId + ")" + " has been deleted!!";
	}

}
