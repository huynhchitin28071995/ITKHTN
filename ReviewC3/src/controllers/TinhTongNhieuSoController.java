package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TinhTongNhieuSoController
 */
@WebServlet("/TinhTongNhieuSoController")
public class TinhTongNhieuSoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TinhTongNhieuSoController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int tong = 0;

		if (request.getParameter("num") != null) {
			String[] nums = request.getParameterValues("num");
			for (String num : nums) {
				tong += Integer.parseInt(num);
			}
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().append("Tổng các số là: ").append(String.valueOf(tong));
		} else {
			request.getRequestDispatcher("views/tinh-tong-nhieu-so.jsp").forward(request, response);
		}

		// request.setAttribute("tong", tong);

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
