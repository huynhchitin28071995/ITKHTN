package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogics.QuangCaoBL;
import javaBeans.QuangCao;

@WebServlet("/QuangCaoServlet")
public class QuangCaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public QuangCaoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<QuangCao> dsqc = QuangCaoBL.docTatCa();
		request.setAttribute("dsqc", dsqc);
		request.getRequestDispatcher("/Views/quang-cao.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
