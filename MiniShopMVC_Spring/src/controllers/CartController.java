package controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import businessLogics.CartBL;
import businessLogics.InvoiceBL;
import javaBeans.Cart;
import javaBeans.NewInvoice;
import util.Helper;

@Controller
@RequestMapping("/cart")
public class CartController {
	@RequestMapping("")
	public String xemCart(Model model, HttpServletRequest request) {
		String id = null;
		for (Cookie cookie : request.getCookies()) {
			if (cookie.getName().equals("cart")) {
				id = cookie.getValue();
			}

		}
		model.addAttribute("title", "Your Cart");
		model.addAttribute("carts", CartBL.getCarts(id));
		return "cart";
	}

	@RequestMapping(path = "/them-cart")
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

	@RequestMapping("/checkout.html")
	public String checkOut(Model model, HttpServletRequest request) {
		String id = null;
		for (Cookie cookie : request.getCookies()) {
			if (cookie.getName().equals("cart")) {
				id = cookie.getValue();
			}

		}
		model.addAttribute("title", "Your Cart");
		model.addAttribute("carts", CartBL.getCarts(id));
		return "checkOut";
	}

	@RequestMapping(value = "checkout")
	public String checkout(Model model, NewInvoice obj, @CookieValue("cart") String id) {
		obj.setId(id);
		InvoiceBL.add(obj);
		return "redirect:/order/detail/" + obj.getId();
	}
}
