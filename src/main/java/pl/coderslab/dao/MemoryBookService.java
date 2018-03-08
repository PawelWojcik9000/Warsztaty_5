package pl.coderslab.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pl.coderslab.entities.Book;

@Component
public class MemoryBookService {

	private List<Book> list;

	public MemoryBookService() {
		list = new ArrayList<>();
		list.add(new Book(1L, "9788324631766", "Thiniking in Java", "Bruce Eckel", "Helion", "adventure"));
		list.add(new Book(2L, "9788324627738", "Rusz glowa Java.", "Sierra Kat", "Helion", "adventure"));
		list.add(new Book(3L, "9780130819338", "Java 2. Podstawy", "Cay Horstm", "Helion", "adventure"));
	}

	public List<Book> getList() {
		return list;
	}

	public void setList(List<Book> list) {
		this.list = list;
	}

}
