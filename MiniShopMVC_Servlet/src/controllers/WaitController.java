package controllers;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/WaitController")
public class WaitController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public WaitController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Waiting at: ").append(request.getContextPath());
//			synchronized (response) {
//			try {
//				response.wait(5000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	}
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

		executorService.schedule(new Runnable() {
			@Override
			public void run() {
//				try {
//					request.getRequestDispatcher("/").forward(request, response);
//				} catch (IOException | ServletException e) {
//					e.printStackTrace();
//				}
				System.out.println("Test schedule");
				try {
					response.getWriter().append("after 3 seconds");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					response.sendRedirect(request.getContextPath());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, 3, TimeUnit.SECONDS);

		System.out.println("Test out of schedule");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
