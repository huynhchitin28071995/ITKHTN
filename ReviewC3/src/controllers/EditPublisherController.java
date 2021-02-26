package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogics.PublisherBL;

@WebServlet("/publisher/edit.html")
public class EditPublisherController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditPublisherController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		if(request.getParameter("publisherId") != null) {
			int publisherId = Integer.parseInt(request.getParameter("publisherId"));
			request.setAttribute("publisher", PublisherBL.getPublisher(publisherId));
		}
		request.getRequestDispatcher("/views/publisher/edit.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String newPublisherName = request.getParameter("publisherName");
		String publisherId = request.getParameter("publisherId");
		
		PublisherBL.editPublisher(Integer.parseInt(publisherId), newPublisherName);
		request.setAttribute("msg", "Edited to " + PublisherBL.getPublisher(Integer.parseInt(publisherId)));
		doGet(request, response);
	}

}
