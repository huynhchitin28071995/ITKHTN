package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.User;
import model.UserRepository;


@Controller
@RequestMapping("/auth")
public class AuthController {
	UserRepository repository = new UserRepository();
	@RequestMapping(value = "register.html", method = RequestMethod.POST)
	public String register(User obj) {
		repository.add(obj);
		return "redirect:/auth/logon.html";
	}
	
	@RequestMapping(path="/logon.html")
	public String logOn() {
		return "auth/logon";
	}
	@RequestMapping(path="/register.html")
	public String register() {
		return "auth/register";
	}
	
}
