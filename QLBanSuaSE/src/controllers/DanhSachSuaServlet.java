package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogics.HangSuaBL;
import businessLogics.LoaiSuaBL;
import businessLogics.SuaBL;
import entity.HangSua;
import entity.LoaiSua;
import entity.Sua;

@WebServlet("/DanhSachSuaServlet")
public class DanhSachSuaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DanhSachSuaServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		// Thi sinh viet them cac lenh vao day de thuc hien
		int trang;
		int tinTrenTrang = 5;
		List<Sua> dsSua;
		if (request.getParameter("trang") == null) {
			trang = 1;
		} else {
			trang = Integer.parseInt(request.getParameter("trang"));
		}
		String maLoai, maHang;
		if (request.getParameter("maLoai") != null) {
			maLoai = request.getParameter("maLoai");
			// System.out.println("select s from Sua s where s.loaiSua.maLoaiSua = '" +
			// maLoai + "'");
			dsSua = SuaBL.docSuaTheoMaLoai(maLoai);
		} else if (request.getParameter("maHang") != null) {
			maHang = request.getParameter("maHang");
			dsSua = SuaBL.docSuaTheoMaHang(maHang);
		} else if (request.getAttribute("dsSua") == null) {
			System.out.println("dsSua is null, create new dsSua");
			dsSua = SuaBL.docSua();
		} else {
			dsSua = (List<Sua>) request.getAttribute("dsSua");
		}
		List<LoaiSua> dsLoaiSua = LoaiSuaBL.docLoaiSua();
		List<HangSua> dsHangSua = HangSuaBL.docHangSua();
		int tongSoTrang = (dsSua.size() / tinTrenTrang) + (dsSua.size() % tinTrenTrang > 0 ? 1 : 0);
		dsSua = dsSua.subList((trang - 1) * tinTrenTrang,
				trang * tinTrenTrang > dsSua.size() ? dsSua.size() : trang * tinTrenTrang);
		request.setAttribute("dsSua", dsSua);
		request.setAttribute("dsLoaiSua", dsLoaiSua);
		request.setAttribute("dsHangSua", dsHangSua);
		System.out.println("tongSoTrang = " + tongSoTrang);
		request.setAttribute("tongSoTrang", tongSoTrang);

		request.getRequestDispatcher("views/danh-sach-sua.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
