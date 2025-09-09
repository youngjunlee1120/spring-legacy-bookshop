package kr.ac.kopo.bookshop.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.ac.kopo.bookshop.model.Attach;
import kr.ac.kopo.bookshop.model.Book;
import kr.ac.kopo.bookshop.pager.Pager;
import kr.ac.kopo.bookshop.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {
	final String path = "book/";
	final String uploadPath = "d:/upload/";

	@Autowired
	BookService service;

	@ResponseBody
	@GetMapping("/attach/delete/{code}")
	String deleteAttach(@PathVariable Long code) {
		if (service.deleteAttach(code))
			return "OK";
		return "FAIL";
	}

	@GetMapping("/detail/{code}")
	String detail(@PathVariable Long code, Model model) {
		Book item = service.item(code);

		model.addAttribute("item", item);
		return path + "detail";
	}

	@GetMapping("/dummy")
	String dummy() {
		service.dummy();

		return "redirect:list";
	}

	@GetMapping("/init")
	String init() {
		service.init();

		return "redirect:list";
	}

	@GetMapping("/list")
	String list(Model model, Pager pager) {
		List<Book> list = service.list(pager);
		model.addAttribute("list", list);
		return path + "list";
	}

	@GetMapping("/add")
	String add() {
		return path + "add";
	}

	@PostMapping("/add")
	String add(Book item, MultipartFile[] uploadFile) {
		if (uploadFile != null) {

			// 목록만들기
			List<Attach> attachs = new ArrayList<Attach>();

			for (MultipartFile file : uploadFile) {
				String filename = file.getOriginalFilename();
				String uuid = UUID.randomUUID().toString();

				try {
					file.transferTo(new File(uploadPath + uuid + "_" + filename));

					Attach image = new Attach();
					image.setFilename(filename);
					image.setUuid(uuid);

					attachs.add(image);
				} catch (IllegalStateException | IOException e) {

					System.out.println(e.getLocalizedMessage());
				}
			}

			item.setAttachs(attachs);
		}

		service.add(item);

		return "redirect:list";
	}

	@GetMapping("/delete/{code}")
	String delete(@PathVariable Long code) {
		service.delete(code);
		return "redirect:../list";
	}

	@GetMapping("/update/{code}")
	String update(@PathVariable Long code, Model model) {
		Book item = service.item(code);
		model.addAttribute("item", item);
		return path + "update";
	}

	@PostMapping("/update/{code}")
	String update(@PathVariable Long code, Book item) {
		item.setCode(code);

		service.update(item);
		return "redirect:../list";
	}
}
