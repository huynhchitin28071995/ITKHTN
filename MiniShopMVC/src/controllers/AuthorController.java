package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import businessLogics.AuthorBL;
import javaBeans.Author;

@Controller
@RequestMapping("/author")
public class AuthorController {
	@RequestMapping("/xem")
	public String author(Model model) {
		// model.addAttribute("dsAuthor", AuthorBL.docTatCa());
		return "author";
	}

	@RequestMapping("/them")
	public String them() {
		return "add-author";
	}

	@RequestMapping(path = "/them", method = RequestMethod.POST)
	public String them(Author author, Model model) {
		model.addAttribute("msg", "Đã thêm author");
		AuthorBL.them(author);
		return "add-author";
	}

	@RequestMapping("/delete")
	public String xoa(@RequestParam(name = "authorId") int authorId) {
		AuthorBL.xoa(authorId);
		return "author";
	}

//	@RequestMapping(path = "/xoaNhieu", method = RequestMethod.POST)
//	public String xoa(@RequestParam(name = "ids") List<Integer> ids) {
//		if (ids != null)
//			AuthorBL.xoa(ids);
//		return "redirect:/author/xem";
//
//	}

	@RequestMapping(path = "/xoaNhieu", method = RequestMethod.POST)
	public String xoa(HttpServletRequest request) {
		String[] ids = request.getParameterValues("ids");
		if (ids != null) {
			List<Integer> listId = new ArrayList<Integer>();
			for (String id : ids) {
				listId.add(Integer.parseInt(id));
			}
			AuthorBL.xoa(listId);
		}
		return "redirect:/author/xem";
	}

	@RequestMapping("/edit/{authorId}")
	public String sua(@PathVariable(name = "authorId") int authorId, Model model) {
		model.addAttribute("authorId", authorId);
		model.addAttribute("authorName", AuthorBL.docTheoId(authorId).getAuthorName());
		return "edit-author";
	}

	@RequestMapping(path = "/edit/{authorId}", method = RequestMethod.POST)
	public String suaPost(Author author, Model model) {
		AuthorBL.sua(author.getAuthorId(), author.getAuthorName());
		model.addAttribute("msg", "đã sửa author");
		return "edit-author";
	}

}
