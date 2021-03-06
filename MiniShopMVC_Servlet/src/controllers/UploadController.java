package controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/upload.html")
@MultipartConfig
public class UploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UploadController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/views/upload/index.jsp").include(request, response);
	}

	private void upload(Part p, String path) {
		String fileName = p.getSubmittedFileName();
		try (InputStream is = p.getInputStream()) {
			try (OutputStream os = new FileOutputStream(new File(path + fileName))) {
				int len = 0;
				byte[] bytes = new byte[1024];
				while ((len = is.read(bytes, 0, 1024)) > 0) {
					os.write(bytes, 0, len);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Part p = request.getPart("f");
		String fileName = p.getSubmittedFileName();
		String path = request.getServletContext().getRealPath("/upload/");
		upload(p, path);
		request.setAttribute("img", fileName);
		doGet(request, response);
	}

}
