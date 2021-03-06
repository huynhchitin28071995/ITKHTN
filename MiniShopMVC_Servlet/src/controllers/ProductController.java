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
		int numOfProductsPerPage = 4;
		List<Product> dsProduct;
		if (request.getParameter("page") != null) {
			dsProduct = ProductBL.getProducts(
					PaginationHelper.computeStart(request.getParameter("page"), numOfProductsPerPage),
					numOfProductsPerPage);
		} else {
			dsProduct = ProductBL.getProducts(1, numOfProductsPerPage);
		}
		int size = ProductBL.count();

		request.setAttribute("dsProduct", dsProduct);
		request.setAttribute("numOfPages", size / numOfProductsPerPage + 1);
		request.getRequestDispatcher("/views/product/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
