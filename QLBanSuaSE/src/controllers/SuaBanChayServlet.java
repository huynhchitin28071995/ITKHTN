package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogics.CtHoadonBL;
import entity.Sua;

@WebServlet("/SuaBanChayServlet")
public class SuaBanChayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SuaBanChayServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		// Thi sinh viet them cac lenh vao day de thuc hien
		// List<CtHoadon> dsBanChayHD = CtHoadonBL.docSuaTheoHoadon().subList(0, 5);
		List<Sua> dsSuaBanChay = CtHoadonBL.docSuaTheoHoadon().subList(0, 5);

		// request.setAttribute("dsBanChayHD", dsBanChayHD);
		request.setAttribute("dsSuaBanChay", dsSuaBanChay);
		request.getRequestDispatcher("views/sua-ban-chay.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
