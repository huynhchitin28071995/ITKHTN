package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {
 @RequestMapping("/register")
 public String register() {
	 return "register";
 }
}
