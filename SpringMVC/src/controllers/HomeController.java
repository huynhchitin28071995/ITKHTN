package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/","/home"})
public class HomeController {
@RequestMapping({"/","/home"})
public String home() {
	return "home";//ten file home khai bao trong tiles.xml <definition name="home"/>
}
}
