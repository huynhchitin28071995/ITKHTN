package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogics.ProductBL;

@WebServlet({ "/ProductController", "/product.html", "/home.html", "/index.html" })
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static int numOfProductsPerPage = 5;
    public ProductController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("dsProduct", ProductBL.getProducts());
		request.setAttribute("n", ProductBL.getProducts().size()/numOfProductsPerPage + 1);
		request.getRequestDispatcher("/views/product/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
