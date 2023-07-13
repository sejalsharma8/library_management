package com.nagarro.library_management.services;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nagarro.library_management.model.Author;

@Service
public interface AuthorService {
	List<Author> getAuthors() ;
}
