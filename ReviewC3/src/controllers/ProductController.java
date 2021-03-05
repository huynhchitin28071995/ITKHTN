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
    private static int numOfProductsPerPage = 4;
    public ProductController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page;
		List<Product> dsProduct = ProductBL.getProducts();
		if(request.getParameter("page")!= null) {
			 page = Integer.parseInt(request.getParameter("page"));
		 } else {
			 page = 1;
		 }
		int start = (page - 1) * numOfProductsPerPage;
		int end = start + numOfProductsPerPage > dsProduct.size()? dsProduct.size():start + numOfProductsPerPage;
		request.setAttribute("dsProduct", dsProduct.subList(start, end));
		request.setAttribute("numOfPages", dsProduct.size()/numOfProductsPerPage + 1);
		request.getRequestDispatcher("/views/product/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
