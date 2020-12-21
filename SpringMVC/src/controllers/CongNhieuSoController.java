package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class CongNhieuSoController {
	@RequestMapping(path = "/congnhieuso", method = RequestMethod.POST)
	public String congNhieuSo(Model model, @RequestParam("so") int[] so) {
		model.addAttribute("so", so);
		int kq = 0;
		for(int s:so) {
			kq+=s;
		}
		model.addAttribute("kq",kq);
		return "cong-nhieu-so";
	}
	@RequestMapping("/congnhieuso")
	public String congNhieuSo() {
		return "cong-nhieu-so";
	}
}
