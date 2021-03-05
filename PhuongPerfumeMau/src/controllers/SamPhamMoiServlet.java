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

@WebServlet("/SamPhamMoiServlet")
public class SamPhamMoiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public SamPhamMoiServlet() {
		super();
	}

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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
