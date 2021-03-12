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

@WebServlet("/home/search.html")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int numOfProductPerPage = 4;

		String searchInput = request.getParameter("q");
		int size = ProductBL.count(searchInput);
		String pageFromRequest = request.getParameter("page");
		List<Product> dsProduct = ProductBL.searchProduct(searchInput,
				PaginationHelper.computeStart(pageFromRequest, numOfProductPerPage), numOfProductPerPage);
		request.setAttribute("dsProduct", dsProduct);
		request.setAttribute("numOfPages", (size - 1) / numOfProductPerPage + 1);
		request.setAttribute("searchInput", searchInput);
		request.getRequestDispatcher("/views/product/search.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
