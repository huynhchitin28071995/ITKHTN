package controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/upload/multi.html")
@MultipartConfig
public class UploadMultipleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UploadMultipleServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/views/upload/uploadmultipleimg.jsp").forward(request, response);
	}

	private void upload(String path, Part part) {
		String fileName = part.getSubmittedFileName();
		try (InputStream is = part.getInputStream()) {
			try (OutputStream os = new FileOutputStream(new File(path + fileName))) {
				int len = 0;
				byte[] bytes = new byte[1024];
				while ((len = is.read(bytes, 0, 1024)) > 0) {
					os.write(bytes, 0, len);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Collection<Part> parts = request.getParts();
		List<String> dsFile = new ArrayList<String>();
		String path = request.getServletContext().getRealPath("/upload/");
		for (Part part : parts) {
			upload(path, part);
			dsFile.add(part.getSubmittedFileName());
		}
		request.setAttribute("dsFile", dsFile);
		doGet(request, response);
	}

}
