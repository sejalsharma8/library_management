package com.nagarro.library_management.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nagarro.library_management.model.Author;
import com.nagarro.library_management.model.Book;
import com.nagarro.library_management.services.AuthorService;
import com.nagarro.library_management.services.BookService;

@Controller
public class BookController {
	@Autowired
	private BookService bookService;
	@Autowired
	private AuthorService authorService;
	List<Book> books = null;
	List<Author> authors = null;
	LocalDateTime date =LocalDateTime.now();
	DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("d MMM YYYY");
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String addBooks(@RequestParam("id") int id,
				@RequestParam("title") String title,
				@RequestParam("author")String author, 
				@RequestParam("date") String date
			) {
		bookService.addBook(new Book(id,title,author,date));
		return "redirect:/welcome";
	}
	@RequestMapping(value = "/welcome")
	public String welcome(Model model) {
		String currentDate = dateformatter.format(date);
		String msg ="";
		boolean success = false;
		try {
			books = null;
			books = bookService.getBooks();
			model.addAttribute("books",books);
		}catch(Exception e) {
			model.addAttribute("msg","No Books Found!!");
			return "redirect:/welcome";
		}
		if(books.isEmpty()) {
			msg="No Record Exist!!";
			model.addAttribute("msg", msg);
			model.addAttribute("success", success);
		}
		try {
			authors = null;
			authors = authorService.getAuthors();
		}catch(Exception e) {
			
		}
		model.addAttribute("authors",authors);
		//model.addAttribute("books",books);
		model.addAttribute("date",currentDate);
		return "welcome";
	}
	@RequestMapping(value="/edit")
	public String editBook(@RequestParam("id") int id,
			Model model) {
		String currentDate = dateformatter.format(date);
		authors = null;
		authors = authorService.getAuthors();
		model.addAttribute("authors",authors);
		model.addAttribute("date",currentDate);
		model.addAttribute("id",id);
		return "editBook";
	}
	@RequestMapping(value="/update",method =RequestMethod.POST)
	public String updateBook(@RequestParam("id") int id,
				@RequestParam("title") String title,
				@RequestParam("author")String author, 
				@RequestParam("date") String date) {
		Book b = new Book(id,title,author,date);
		bookService.updateBook(b);
		return "redirect:/welcome";
	}
	@RequestMapping(value="/delete")
	public String deleteBook(@RequestParam("id") int id) {
		bookService.deleteBook(id);
		return "redirect:/welcome";
	}
}
