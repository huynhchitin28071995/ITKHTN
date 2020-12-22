package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogics.SanPhamBL;
import javaBeans.SanPham;

/**
 * Servlet implementation class SamPhamMoiServlet
 */
@WebServlet("/SamPhamMoiServlet")
public class SamPhamMoiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SamPhamMoiServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String sql = "select * from phuong_perfume.sanpham order by ngaytao desc limit 0,10";
		List<SanPham> dsspm = SanPhamBL.taoDanhSach(sql);
		request.setAttribute("dsspm", dsspm);
		request.getRequestDispatcher("/Views/san-pham-moi.jsp").include(request, response);
//		dsspm.forEach(sp -> {
//			System.out.println(sp.getHinhAnh());
//
//		});
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
