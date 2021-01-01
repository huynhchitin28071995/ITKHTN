package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {
	@RequestMapping("/detail/{id}")
	public String detail(@CookieValue(name = "cart") String id, @PathVariable(name = "id") String invId, Model model) {

		return "order-detail";

	}
}
