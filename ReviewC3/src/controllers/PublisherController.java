package controllers;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogics.PublisherBL;

@WebServlet({"/admin/publisher.html","/publisher/dels.html"})
public class PublisherController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PublisherController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("dsPublisher", PublisherBL.getPublishers());
		request.getRequestDispatcher("../views/publisher/publisher.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] publisherIds = request.getParameterValues("boxes");
		List<Integer> list = new LinkedList<Integer>();
		for (String id : publisherIds) {
			list.add(Integer.parseInt(id));
		}
		PublisherBL.multiDels(list);
		doGet(request, response);
	}

}
