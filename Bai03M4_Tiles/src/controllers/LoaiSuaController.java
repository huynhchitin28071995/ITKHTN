package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import businessLogics.LoaiSuaBL;
import javaBeans.LoaiSua;

@Controller
@RequestMapping("/loaisua")
public class LoaiSuaController {
	@RequestMapping("/them")		//ngam dinh method=RequestMethod.GET
	public String them() {
		//return "them-loai-sua";
		return "themLoaiSua";		//ten dinh nghia trong tiles.xml
	}
//	@RequestMapping(path = "/them", method=RequestMethod.POST)
//	public String them2(Model model) {
//		model.addAttribute("maLoai", "AA");
//		model.addAttribute("tenLoai", "Sữa AAAAA");
//		return "them-loai-sua";
//	}

	//	@RequestMapping(path = "/them", method=RequestMethod.POST)
//	public ModelAndView them2() {
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("maLoai", "AA");
//		mav.addObject("tenLoai", "Sữa AAAAA");
//		mav.setViewName("them-loai-sua");
//		return mav;
//	}

	@RequestMapping(path = "/them", method=RequestMethod.POST)
	public String them2(HttpServletRequest request, Model model) {
		String ml, tl;
		ml = request.getParameter("txtMaLoai");
		tl = request.getParameter("txtTenLoai");
		
		LoaiSua ls = new LoaiSua();
		ls.setMaLoai(ml);
		ls.setTenLoai(tl);
		
		LoaiSuaBL.them(ls);
		model.addAttribute("maLoai", ml);
		model.addAttribute("tenLoai", tl);
		return "them-loai-sua";
	}

	@RequestMapping("/them2")		//ngam dinh method=RequestMethod.GET
	public String them2() {
		return "them-loai-sua2";
	}
	@RequestMapping(path = "/them2", method=RequestMethod.POST)
	public String them2(LoaiSua ls, Model model) {
//		String ml, tl;
//		ml = request.getParameter("txtMaLoai");
//		tl = request.getParameter("txtTenLoai");
//		
//		LoaiSua ls = new LoaiSua();
//		ls.setMaLoai(ml);
//		ls.setTenLoai(tl);
		
		LoaiSuaBL.them(ls);
		model.addAttribute("ls",ls);
		return "them-loai-sua2";
	}
	
	@RequestMapping("/danh-sach")
	public String tim(Model model) {
		List<LoaiSua> ds = LoaiSuaBL.docTatCa();
		model.addAttribute("dsls", ds);
		//return "tim-loai-sua";
		return "danhSachLoaiSua";
	}
	@RequestMapping("/tim/{maLoai}")
	public String tim2(@PathVariable(name = "maLoai") String ml, Model model) {
		LoaiSua ls = LoaiSuaBL.docTheoMaLoai(ml);
		List<LoaiSua> dsls = new ArrayList<>();
		dsls.add(ls);
		model.addAttribute("dsls", dsls);
		return "tim-loai-sua";
	}
	
	@RequestMapping("/timloai")
	public String tim3(@RequestParam(name = "ml") String ml, Model model) {
		LoaiSua ls = LoaiSuaBL.docTheoMaLoai(ml);
		List<LoaiSua> dsls = new ArrayList<>();
		dsls.add(ls);
		model.addAttribute("dsls", dsls);
		return "tim-loai-sua";
	}
	
//	@RequestMapping("/timloai")
//	public String tim3(HttpServletRequest request, Model model) {
//		String ml = request.getParameter("ml");
//		LoaiSua ls = LoaiSuaBL.docTheoMaLoai(ml);
//		List<LoaiSua> dsls = new ArrayList<>();
//		dsls.add(ls);
//		model.addAttribute("dsls", dsls);
//		return "tim-loai-sua";
//	}
	
	@RequestMapping("/xoa")
	public String xoa() {
		return "xoa-loai-sua";		//WEB-INF/views/xoa-loai-sua.jsp
	}
}
