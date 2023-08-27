package com.boyishi.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.boyishi.demo.entities.Book;

@Service
public interface BookRepository extends JpaRepository<Book, Long> {

}
