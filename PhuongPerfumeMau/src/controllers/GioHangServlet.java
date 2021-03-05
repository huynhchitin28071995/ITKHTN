package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import businessLogics.GioHangBL;
import javaBeans.SanPhamMua;

@WebServlet({"/GioHangServlet"})
public class GioHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GioHangServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		GioHangBL gioHang = (GioHangBL) session.getAttribute("gioHang");
		if (gioHang != null) {
			List<SanPhamMua> dsspMua = gioHang.danhSachSanPhamMua();
			session.setAttribute("dsspMua", dsspMua);
			double thanhTien = 0;
			for (SanPhamMua spMua : dsspMua) {
				thanhTien += spMua.thanhTien();
			}
			session.setAttribute("thanhTien", thanhTien);
		}
//		response.sendRedirect(request.getContextPath() + "/trang-gio-hang.jsp");
		request.getRequestDispatcher("/Views/gio-hang.jsp").include(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
