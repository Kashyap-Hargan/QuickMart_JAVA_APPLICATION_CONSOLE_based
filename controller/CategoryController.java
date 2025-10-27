package com.example.demo.controller;
 
import com.example.demo.model.Category;
import com.example.demo.services.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
 
import java.util.List;
 
@Controller
@RequestMapping("/category")
public class CategoryController {
 
    private final CategoryService service;
 
    public CategoryController(CategoryService service) {
        this.service = service;
    }
 
    @GetMapping
    public String getAllCategories(Model model) {
        List<Category> categories = service.findAll();
        model.addAttribute("categories", categories);
        return "category-view";  // This will map to category-list.html
    }
 
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("category", new Category());
        return "category-create";  // category-form.html
    }
 
    @PostMapping
    public String saveCategory(@ModelAttribute("category") Category category) {
        service.save(category);
        return "redirect:/category";
    }
 
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Category category = service.findById(id).orElse(null);
        model.addAttribute("category", category);
        return "category-create";
    }
 
    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/category";
    }
}