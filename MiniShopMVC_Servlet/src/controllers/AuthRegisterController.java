package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogics.MemberBL;
import models.Member;

@WebServlet("/auth/register.html")
public class AuthRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AuthRegisterController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/views/auth/register.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fullName = request.getParameter("fullName");
		String email = request.getParameter("email");
		String username = request.getParameter("usr");
		String password = request.getParameter("pwd");
		Byte gender = Byte.parseByte(request.getParameter("gender"));
		Member member = new Member.Builder().email(email).fullName(fullName).username(username).password(password)
				.gender(gender).build();
		if (MemberBL.addMember(member)) {
			request.setAttribute("msg", "Register successfully!");
			request.getRequestDispatcher("/WaitController").forward(request, response);
//			synchronized (response) {
//				try {
//					response.wait(1500);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//
//			}
//			request.getRequestDispatcher("").forward(request, response);
//			response.sendRedirect(request.getContextPath());
		} else {
			request.setAttribute("msg", "Register failed! Use another user name!");
			doGet(request, response);
		}

	}

}
