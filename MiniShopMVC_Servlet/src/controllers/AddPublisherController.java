package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogics.PublisherBL;
import models.Publisher;

@WebServlet("/publisher/add.html")
public class AddPublisherController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddPublisherController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.getRequestDispatcher("/views/publisher/add.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg;
		if (request.getParameter("publisherName") != null) {
			Publisher p = new Publisher.Builder().publisherName(request.getParameter("publisherName")).build();
			PublisherBL.addPublisher(p);
			msg = "Added " + p.toString();
		} else {
			msg = "Failed to add!";
		}
		request.setAttribute("msg",msg);
		doGet(request, response);
		
		
	}

}
