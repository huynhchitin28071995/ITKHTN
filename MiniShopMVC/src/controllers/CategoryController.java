package controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import businessLogics.CategoryBL;
import javaBeans.Category;

@Controller
@RequestMapping("/user/category")
public class CategoryController {
	List<Category> dsParent = CategoryBL.docParent();
	List<Category> dsCategory = CategoryBL.docTatCa();

	@RequestMapping("/category")
	public String dsCategory(Model model) {
		model.addAttribute("dsCategory", dsCategory);
		return "category";
	}

	@RequestMapping("/add-category")
	public String addCategory(Model model) {
		model.addAttribute("dsCategory", dsCategory);
		Map<Integer, String> mapParent = new HashMap<>();
		dsParent.forEach(pr -> {
			mapParent.put(pr.getCategoryId(), pr.getCategoryName());
		});
		model.addAttribute("mapParent", mapParent);
		model.addAttribute("obj", new Category());
		return "add-category";
	}

	@RequestMapping(path = "/add-category", method = RequestMethod.POST)
	public String addCategory(Model model, Category obj) {
		CategoryBL.themCategory(obj);
		return "redirect:/user/category/category";
	}
}
