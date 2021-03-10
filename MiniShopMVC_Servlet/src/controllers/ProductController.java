package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogics.ProductBL;
import models.Product;

@WebServlet({ "/ProductController", "/product.html", "/home.html", "/index.html" })
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProductController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int page;
		int numOfProductsPerPage = 4;
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		} else {
			page = 1;
		}
		int size = ProductBL.count();
		int start = (page - 1) * numOfProductsPerPage;
		List<Product> dsProduct = ProductBL.getProducts(start, numOfProductsPerPage);
		request.setAttribute("dsProduct", dsProduct);
		request.setAttribute("numOfPages", size / numOfProductsPerPage + 1);
		request.getRequestDispatcher("/views/product/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
