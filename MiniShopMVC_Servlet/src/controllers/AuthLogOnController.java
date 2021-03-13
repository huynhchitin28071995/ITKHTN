package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import businessLogics.MemberBL;
import models.Member;

@WebServlet("/auth/logon.html")
public class AuthLogOnController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AuthLogOnController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/views/auth/logon.jsp").forward(request, response);
	}

	private static void savedCookie(HttpServletRequest request, HttpServletResponse response) {
		for (Cookie cookie : request.getCookies()) {
			if (cookie.getName().equals("JSESSIONID")) {
				cookie.setMaxAge(180);
				cookie.setPath(request.getContextPath());
				response.addCookie(cookie);
			}
		}
	}

	private static void savedSession(Member member, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.setAttribute("member", member);
		if (request.getParameter("remember") != null) {
			savedCookie(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("usr");
		String password = request.getParameter("pwd");
		Member member = MemberBL.logOn(userName, password);
		if (member != null) {
			savedSession(member, request, response);
			response.sendRedirect(request.getContextPath());
		} else {
			request.setAttribute("msg", "Log on failed!");
			doGet(request, response);
		}

	}

}
