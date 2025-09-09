package kr.ac.kopo.bookshop.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.bookshop.model.Attach;
import kr.ac.kopo.bookshop.model.Book;
import kr.ac.kopo.bookshop.pager.Pager;

@Repository
public class BookDaoImpl implements BookDao {

	@Autowired
	SqlSession sql;

	@Override
	public List<Book> list(Pager pager) {

		return sql.selectList("book.list", pager);
	}

	@Override
	public void add(Book item) {
		sql.insert("book.add", item);
	}

	@Override
	public void delete(Long code) {
		sql.delete("book.delete", code);
	}

	@Override
	public Book item(Long code) {

		return sql.selectOne("book.item", code);
	}

	@Override
	public void update(Book item) {
		sql.update("book.update", item);
	}

	@Override
	public int total(Pager pager) {
		return sql.selectOne("book.total", pager);
	}

	@Override
	public void addAttach(Attach image) {
		sql.insert("book.add_attach", image);
	}

	@Override
	public int deleteAttach(Long code) {

		return sql.delete("book.delete_attach", code);
	}

}
