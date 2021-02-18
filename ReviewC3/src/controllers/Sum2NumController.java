package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Sum2NumController
 */
@WebServlet("/Sum2NumController")
public class Sum2NumController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Sum2NumController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String a = request.getParameter("numA");
		String b = request.getParameter("numB");
		if (a != null && b != null) {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().append("Tổng 2 số: ")
					.append(String.valueOf(Integer.parseInt(a) + Integer.parseInt(b)));
		} else {
			request.getRequestDispatcher("/views/TinhTong2So.jsp").forward(request, response);
		}
		;
//		try {
//			int a = Integer.parseInt(Objects.requireNonNull(request.getParameter("numA"), "parameter numA is null"));
//
//			int b = Integer.parseInt(Objects.requireNonNull(request.getParameter("numB"), "parameter numB is null"));
//			response.setContentType("text/html;charset=utf-8");
//			response.getWriter().append("Tổng 2 số: ").append(String.valueOf(a + b));
//		} catch (Exception e) {
//			e.printStackTrace();
//			request.getRequestDispatcher("/views/TinhTong2So.jsp").forward(request, response);
//
//		}
//		;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
