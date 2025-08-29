package kr.ac.kopo.bookshop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.kopo.bookshop.model.Member;
import kr.ac.kopo.bookshop.service.MemberService;

@Controller
public class RootController {
	@Autowired
	MemberService service;

	@GetMapping("/")
	String index() {
		return "index";
	}

	@GetMapping("/signup")
	String signup() {
		return "signup";
	}

	@PostMapping("/signup")
	String signup(Member item) {
		service.add(item);
		return "redirect:/";
	}

	@GetMapping("/login")
	String login() {
		return "login";
	}

	@PostMapping("/login")
	String login(Member member, HttpSession session) {
		if (service.login(member)) {
			session.setAttribute("member", member);
		}

		return "redirect:.";
	}

	@GetMapping("/logout")
	String logout(HttpSession session) {
		// 세션 무효화
		session.invalidate();

		return "redirect:.";
	}

	@ResponseBody
	@GetMapping("/check_id/{id}")
	String checkId(@PathVariable String id) {
		System.out.println(id);
		return "OK";
	}
}
