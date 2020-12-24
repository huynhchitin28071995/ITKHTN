package controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import businessLogics.ProductBL;
import javaBeans.Product;

@Controller
@RequestMapping("/product")
public class ProductController {
@RequestMapping("/xem")
public String xemProduct(Model model) {
	List<Product> dsProduct = ProductBL.docTatCa();
	model.addAttribute("dsProduct", dsProduct);
	return "product";
}
}
