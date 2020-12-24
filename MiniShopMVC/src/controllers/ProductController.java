package controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import businessLogics.ProductBL;
import javaBeans.Product;

@Controller
@RequestMapping("/product")
public class ProductController {
	List<Product> dsProduct = ProductBL.docTatCa();
	int soMauTinTrenTrang = 2;
	int soMauTin = dsProduct.size();
	int tongSoTrang = (int) Math.ceil((double) soMauTin / soMauTinTrenTrang);

	@RequestMapping("/xem")
	public String xemProduct(Model model) {

		model.addAttribute("tongSoTrang", tongSoTrang);
		model.addAttribute("dsProduct", dsProduct);

		return "redirect:/product/xem/1";
	}

	@RequestMapping(path = "/xem/{trang}")
	public String xemProductTrang(@PathVariable(name = "trang") int trang, Model model) {
		if (trang >= tongSoTrang) {
			trang = tongSoTrang;
		}
		if (trang <= 1) {
			trang = 1;
		}
		model.addAttribute("dsProduct", dsProduct.subList(soMauTinTrenTrang * (trang - 1),
				(soMauTinTrenTrang * (trang - 1) + 2) < soMauTin ? (soMauTinTrenTrang * (trang - 1) + 2) : soMauTin));
		model.addAttribute("tongSoTrang", tongSoTrang);

		model.addAttribute("trangHienTai", trang);
		return "product";
	}
}
