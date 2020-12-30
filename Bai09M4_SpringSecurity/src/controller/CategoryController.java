package controller;

import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Category;
import model.CategoryRepository;

@Controller
@RequestMapping("admin/category")
public class CategoryController{
	CategoryRepository repository = new CategoryRepository();
	@RequestMapping("index.html")
	public String index(Model model) {
		model.addAttribute("list", repository.getCategories() );
		return "category/index";
	}
	
	@ModelAttribute("map")
	public List<Category> map(){
		return repository.getCategories();
	}
	@RequestMapping("add.html")
	public String add(Model model) {
		//List<Category> list = repository.getParents();
		//model.addAttribute("map", list);
		model.addAttribute("obj", new Category());
		return "category/add";
	}
	@RequestMapping(value="add.html", method=RequestMethod.POST)
	public String add(Model model, Category obj) {
		repository.add(obj);
		return "redirect:/admin/category/index.html";
	}
	@RequestMapping("edit.html/{id}")
	public String edit(Model model, @PathVariable("id") int id) {
		//model.addAttribute("map", repository.getParents());
		model.addAttribute("obj", repository.getCategory(id));
		return "category/edit";
	}
	@RequestMapping(value="edit.html/{id}", method=RequestMethod.POST)
	public String edit(Model model, Category obj, @PathVariable("id") int id) {
		repository.edit(obj);
		return "redirect:/admin/category/index.html";
	}
	
}
