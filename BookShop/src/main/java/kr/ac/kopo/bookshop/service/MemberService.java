package kr.ac.kopo.bookshop.service;

import java.util.List;

import kr.ac.kopo.bookshop.model.Member;

public interface MemberService {

	List<Member> list();

	void add(Member item);

	void update(Member item);

	void delete(String id);

	Member item(String id);

	boolean login(Member member);

}
