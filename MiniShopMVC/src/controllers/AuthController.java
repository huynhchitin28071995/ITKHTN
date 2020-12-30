package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import businessLogics.UserBL;
import javaBeans.User;

@Controller
@RequestMapping("/auth")
public class AuthController {
	@RequestMapping("/register.html")
	public String register() {
		return "register";
	}

	@RequestMapping("/logon.html")
	public String logOn() {
		return "logon";
	}

	@RequestMapping(path = "/register.html", method = RequestMethod.POST)
	public String register(User user) {
		UserBL.add(user);
		return "redirect:/auth/logon.html";
	}

}
