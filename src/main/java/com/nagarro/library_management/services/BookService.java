package com.nagarro.library_management.services;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nagarro.library_management.model.Book;

@Service
public interface BookService {
	List<Book> getBooks() ;
	void addBook(Book b);
	void updateBook(Book b);
	void deleteBook(int id);
}
