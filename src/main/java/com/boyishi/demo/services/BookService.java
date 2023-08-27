package com.boyishi.demo.services;

import java.util.List;

import org.springframework.stereotype.Component;
import com.boyishi.demo.entities.Book;

@Component
public interface BookService {
	Book post(Book params);
	
	List<Book> get();
	
	Book update(Book params, long bookId);
	
	String delete(long bookId);

	Book get(long bookId);
}
