package controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import businessLogics.AuthorBL;

@Controller
@RequestMapping("/author")
public class AuthorController {
@RequestMapping("/xem")
public String author(Model model) {
	model.addAttribute("dsAuthor", AuthorBL.docTatCa());
	return "author";
}
@RequestMapping("/them")
public String them(HttpServletRequest request) {
	return "add-author";
}
}
