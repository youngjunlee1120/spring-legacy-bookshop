package kr.ac.kopo.bookshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import kr.ac.kopo.bookshop.model.Member;

@Controller
@RequestMapping("/book")
public class BookController {
	@GetMapping("/list")
	String list(@SessionAttribute Member member) {

		return "book/list";
	}
}
