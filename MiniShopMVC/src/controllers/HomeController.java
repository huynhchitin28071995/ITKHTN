package controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import businessLogics.CategoryBL;
import javaBeans.Category;

@Controller
public class HomeController {
	List<Category> dsParent = CategoryBL.docParent();
	List<Category> dsCategory = CategoryBL.docTatCa();
@RequestMapping({"/","/home"})
public String home(Model model) {
	model.addAttribute("dsCategory", dsCategory);
	return "home";
}

@RequestMapping("/xem-chim")
public String xemChim() {
	return "xem-chim";
}

@RequestMapping("/dang-nhap")
public String dangNhap() {
	return "dang-nhap";
}
@RequestMapping(path="/dang-nhap", method = RequestMethod.POST)
public String dangNhap(HttpServletRequest request,@RequestParam (value="userName") String userName, @RequestParam(value="password")String password) {
	
	if(userName.equals("hct") && password.equals("123")) {
		HttpSession session = request.getSession();
		session.setAttribute("nguoiDung", userName);
		session.setMaxInactiveInterval(15);
		
	} 
	return "redirect:/xem-chim";
}
}
