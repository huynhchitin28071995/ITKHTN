package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogics.PublisherBL;

@WebServlet("/admin/publisher/del.html")
public class DeletePublisherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeletePublisherServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("publisherId") != null) {
			int id = Integer.parseInt(request.getParameter("publisherId"));
			PublisherBL.deletePublisher(id);
			response.sendRedirect(request.getContextPath() + "/admin/publisher.html");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
