package kr.ac.kopo.bookshop.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.bookshop.model.Member;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Autowired
	SqlSession sql;

	@Override
	public List<Member> list() {
		return sql.selectList("member.list");
	}

	@Override
	public void add(Member item) {
		sql.insert("member.add", item);

	}

	@Override
	public void update(Member item) {
		sql.update("member.update", item);

	}

	@Override
	public void delete(String id) {
		sql.delete("member.delete", id);
	}

	@Override
	public Member item(String id) {
		return sql.selectOne("member.item", id);
	}

}
