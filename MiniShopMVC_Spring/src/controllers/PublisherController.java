package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/publisher")
public class PublisherController {
	
	@RequestMapping("")
	public String publisher() {
		return "publisher";
	}
}