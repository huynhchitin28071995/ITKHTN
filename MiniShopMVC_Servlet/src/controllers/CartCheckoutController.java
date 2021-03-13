package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import businessLogics.InvoiceBL;
import models.Cart;
import models.Invoice;
import models.InvoiceDetail;
import models.Member;

@WebServlet("/cart/checkout.html")
public class CartCheckoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CartCheckoutController() {
		super();
	}

	private static long random() {
		Random rand = new Random();
		return Math.abs(rand.nextLong());
	}

	private static Map<Integer, Cart> getCarts(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("cart");
		Map<Integer, Cart> carts = null;
		if (obj != null) {
			carts = (Map<Integer, Cart>) obj;
		} else {
			carts = new HashMap();
			session.setAttribute("cart", carts);
		}
		return carts;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("list", getCarts(request, response).values());
		request.getRequestDispatcher("/views/cart/checkout.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		Invoice invoice = new Invoice(random(), null, tel, address, email);
		Member member = getMember(request, response);
		if (member != null) {
			invoice.setMemberId(member.getId());
		}
		List<InvoiceDetail> details = new LinkedList<>();
		for (Cart cart : getCarts(request, response).values()) {
			details.add(new InvoiceDetail(invoice.getId(), cart.getProductId(), cart.getQuantity(), cart.getPrice()));
		}
		invoice.setDetails(details);
		try {
			if (InvoiceBL.addToDatabase(invoice) > 0) {
				response.sendRedirect(request.getContextPath() + "/order/detail.html?id=" + invoice.getId());
			} else {
				request.setAttribute("msg", "Ordered Failed");
				doGet(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private static Member getMember(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		if (session.getAttribute("member") != null) {
			return (Member) session.getAttribute("member");
		} else {
			return null;
		}

	}

}
