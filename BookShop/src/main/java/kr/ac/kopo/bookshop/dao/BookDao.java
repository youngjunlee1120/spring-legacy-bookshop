package kr.ac.kopo.bookshop.dao;

import java.util.List;

import kr.ac.kopo.bookshop.model.Attach;
import kr.ac.kopo.bookshop.model.Book;
import kr.ac.kopo.bookshop.pager.Pager;

public interface BookDao {

	List<Book> list(Pager pager);

	void add(Book item);

	void delete(Long code);

	Book item(Long code);

	void update(Book item);

	int total(Pager pager);

	void addAttach(Attach image);

}
