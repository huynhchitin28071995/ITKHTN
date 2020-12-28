package controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import businessLogics.CartBL;
import javaBeans.Cart;
import util.Helper;

@Controller
@RequestMapping("/cart")
public class CartController {
	@RequestMapping("")
	public String xemCart(Model model, @CookieValue("cart") String id) {
		model.addAttribute("title", "Your Cart");
		model.addAttribute("carts", CartBL.getCarts(id));
		return "cart";
	}

	@RequestMapping(path = "/them-cart", method = RequestMethod.POST)
	public String themCart(HttpServletRequest request, Model model, Cart obj, HttpServletResponse response) {
		String id = null;
		System.out.println(request.getServletContext().getContextPath());
		for (Cookie cookie : request.getCookies()) {
			if (cookie.getName().equals("cart")) {
				id = cookie.getValue();
			}

		}
		if (id == null) {
			id = Helper.randomString(32);
			Cookie cookie = new Cookie("cart", id);
			cookie.setPath(request.getServletContext().getContextPath());
			cookie.setMaxAge(60);
			response.addCookie(cookie);
			System.out.println("Da tao cookie moi");
		}
		obj.setId(id);
		CartBL.add(obj);
		return "redirect:/cart";

	}
}
