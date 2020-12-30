package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogics.LoaiSuaBL;
import entity.LoaiSua;

/**
 * Servlet implementation class CapNhatLoaiSuaServlet
 */
@WebServlet({"/CapNhatLoaiSuaServlet","/loai-sua.html"})
public class CapNhatLoaiSuaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CapNhatLoaiSuaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<LoaiSua> dsls = LoaiSuaBL.docTatCa();
		request.setAttribute("dsls",dsls);
		request.getRequestDispatcher("cap-nhat-loai-sua.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maLoai, tenLoai;
		LoaiSua loaiSua = null;

		String chon = request.getParameter("btnChon");

		if (chon != null) {
			maLoai = request.getParameter("txtMaLoai");
			tenLoai = request.getParameter("txtTenLoai");

			loaiSua = new LoaiSua();
			loaiSua.setMaLoaiSua(maLoai);
			loaiSua.setTenLoai(tenLoai);
			try {
				switch (chon) {
				case "them":
					LoaiSuaBL.them(loaiSua);
					break;
				case "tim":
					loaiSua = LoaiSuaBL.docTheoMa(maLoai);
					break;
				case "sua":
					LoaiSuaBL.sua(loaiSua);
					break;
				case "xoa":
					LoaiSuaBL.xoa(maLoai);
					loaiSua = null;
					break;
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		request.setAttribute("loaiSua", loaiSua);
		doGet(request, response);
	}

}