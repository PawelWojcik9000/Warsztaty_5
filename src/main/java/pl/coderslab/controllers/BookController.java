package pl.coderslab.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.coderslab.dao.MemoryBookService;
import pl.coderslab.entities.Book;

@RestController
@RequestMapping("/books")
public class BookController {

	@RequestMapping("/hello")
	public String hello() {
		return "{hello:	World}";
	}

	@RequestMapping("/helloBook")
	public Book helloBook() {
		return new Book(1L, "9788324631766", "JAVA costam", "Bruce Eckel", "Helion", "adventure");
	}

	MemoryBookService memoryBookService;

	@Autowired
	public void setMemoryBookService(MemoryBookService memory) {
		this.memoryBookService = memory;
	}

	@RequestMapping({ "/getallbooks", "/" })
	public List<Book> getAllBooks() {
		return memoryBookService.getList();
	}

	@RequestMapping("/getbookbyid/{id}")
	public Book getBookById(@PathVariable long id) {
		List<Book> books = memoryBookService.getList();
		Book foundBook = null;
		for (Book book : books) {
			if (book.getId() == id)
				foundBook = book;
		}
		return foundBook;
	}

	@PostMapping("/addbook")
	public void addBook(@RequestBody Book book) {
		// operacje na obiekcie book
	}

}
