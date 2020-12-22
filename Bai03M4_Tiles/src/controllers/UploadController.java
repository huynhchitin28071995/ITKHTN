package controllers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	@RequestMapping("/upload-file")
	public String upLoadFile() {
		return "uploadFile"; // ten dinh nghia trong tiles.xml
	}

//	@RequestMapping(path = "/upload-file", method = RequestMethod.POST)
//	public String upLoadFile(MultipartFile[] tt, HttpServletRequest request) {
//		String path = request.getServletContext().getRealPath("/upload/");
//		System.out.println(path);
//		for (MultipartFile mf : tt) {
//			String fileName = mf.getOriginalFilename();
//			System.out.println(fileName);
//			try {
//				byte[] mb = mf.getBytes();
//				OutputStream os = new FileOutputStream(path + fileName);
//				os.write(mb);
//				os.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		return "uploadFile"; // ten dinh nghia trong tiles.xml
//	}

	@RequestMapping(path = "/upload-file", method = RequestMethod.POST)
	public String uploadFile(MultipartFile[] files, HttpServletRequest request) {
		String path = request.getServletContext().getRealPath("/upload/");
		System.out.println(path);
		for (MultipartFile mf : files) {
			String fileName = mf.getOriginalFilename();
			System.out.println(fileName);
			try {
				byte[] mb = mf.getBytes();
				OutputStream fos = new FileOutputStream(path + fileName);

				fos.write(mb);
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "uploadFile";
	}
}
