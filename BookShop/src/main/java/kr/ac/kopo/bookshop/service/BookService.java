package kr.ac.kopo.bookshop.service;

import java.util.List;

import kr.ac.kopo.bookshop.model.Book;

public interface BookService {
	List<Book> list();

	void add(Book item);

	void delete(Long code);

	Book item(Long code);

	void update(Book item);
}
