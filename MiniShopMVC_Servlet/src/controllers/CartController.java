package controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import businessLogics.ProductBL;
import models.Cart;
import models.Product;

@WebServlet("/cart.html")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CartController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("list", getCarts(request, response));
		request.getRequestDispatcher("/views/cart/index.jsp").forward(request, response);
	}

	private Map<Integer, Cart> getCarts(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("cart");
		Map<Integer, Cart> carts = null;
		if (obj != null) {
			carts = (Map<Integer, Cart>) obj;
		} else {
			carts = new HashMap<>();
			session.setAttribute("cart", carts);
		}
		return carts;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int productId = Integer.parseInt(request.getParameter("productId"));
		short quantity = Short.parseShort(request.getParameter("qty"));
		Map<Integer, Cart> carts = getCarts(request, response);
		if (carts.containsKey(productId)) {
			carts.get(productId).increaseQuantity(quantity);
		} else {
			Product product = ProductBL.getProductById(productId);
			Cart cart = new Cart(product.getProductId(), product.getPrice(), quantity, product.getImageURL(),
					product.getTitle());
			carts.put(productId, cart);
		}
		saveCarts(carts, request, response);

		doGet(request, response);
	}

	private void saveCarts(Map<Integer, Cart> carts, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.setAttribute("cart", carts);
	}

}
