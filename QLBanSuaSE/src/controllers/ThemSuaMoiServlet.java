package controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import businessLogics.HangSuaBL;
import businessLogics.LoaiSuaBL;
import businessLogics.SuaBL;
import entity.HangSua;
import entity.LoaiSua;
import entity.Sua;

@WebServlet("/ThemSuaMoiServlet")
@MultipartConfig
public class ThemSuaMoiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ThemSuaMoiServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		// Thi sinh viet them cac lenh vao day de thuc hien
		List<LoaiSua> dsLoaiSua = LoaiSuaBL.docLoaiSua();
		request.setAttribute("dsLoaiSua", dsLoaiSua);
		List<HangSua> dsHangSua = HangSuaBL.docHangSua();
		request.setAttribute("dsHangSua", dsHangSua);

		request.getRequestDispatcher("/views/them-sua-moi.jsp").include(request, response);
	}

	private void upload(Part part, File file) {
		try (InputStream is = part.getInputStream()) {
			try (OutputStream os = new FileOutputStream(file)) {
				int len = 0;
				byte[] b = new byte[1024];
				while ((len = is.read(b, 0, 1024)) > 0) {
					os.write(b, 0, len);
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Part part = request.getPart("file");
		File file = new File(request.getServletContext().getRealPath("/images/") + part.getSubmittedFileName());
		System.out.println(request.getServletContext().getRealPath("/images/") + part.getSubmittedFileName());
		upload(part, file);

		Sua sua = new Sua();
		sua.setMaSua(request.getParameter("txtMaSua"));
		sua.setTenSua(request.getParameter("txtTenSua"));
		sua.setLoaiSua(LoaiSuaBL.timLoaiSua(request.getParameter("cboLoaiSua")));
		sua.setHangSua(HangSuaBL.timHangSua(request.getParameter("cboHangSua")));
		sua.setTrongLuong(Integer.parseInt(request.getParameter("txtTrongLuong")));
		sua.setDonGia(Integer.parseInt(request.getParameter("txtDonGia")));
		sua.setTpDinhDuong(request.getParameter("txtTPDinhDuong"));
		sua.setLoiIch(request.getParameter("txtLoiIch"));
		sua.setHinh(part.getSubmittedFileName());
		SuaBL.themSua(sua);
		// String txtTenSua = request.getParameter("txtTenSua");
		// String txtHangSua = request.getParameter("cboHangSua");
		System.out.println(sua.getMaSua());
		System.out.println(sua.getTenSua());
		System.out.println(sua.getLoaiSua().getTenLoai());
		System.out.println(sua.getHangSua().getTenHangSua());
		System.out.println(sua.getTrongLuong());
		System.out.println(sua.getDonGia());
		System.out.println(sua.getTpDinhDuong());
		System.out.println(sua.getLoiIch());
		System.out.println(sua.getHinh());

		response.sendRedirect("trang-them-sua-moi.jsp");
	}

}
