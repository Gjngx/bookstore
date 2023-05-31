package com.example._DangNhatGiang.controller;

import com.example._DangNhatGiang.entity.Category;
import com.example._DangNhatGiang.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping
    public String showAllCategory(Model model){
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories",categories);
        return "category/list";
    }
    @GetMapping("/add")
    public String addCategoryForm(Model model){
        model.addAttribute("category",new Category());
        return "category/add";
    }
    @PostMapping("/add")
    public String addCategory(@ModelAttribute("category")Category category, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "category/add";
        }
        categoryService.addCatetory(category);
        return "redirect:/categories";
    }
    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long Id) {
        categoryService.deleteCategory(Id);
        return "redirect:/categories";
    }
    @GetMapping("/edit/{id}")
    public String editCategoryForm(@PathVariable("id") Long Id, Model model) {
        Category category = categoryService.getCategoryById(Id);
        model.addAttribute("category", category);
        return "category/edit";
    }

    @PostMapping("/edit/{id}")
    public String editCategory(@PathVariable("id") Long Id, @ModelAttribute("category") Category updatedCategory) {
        Category category = categoryService.getCategoryById(Id);
        category.setName(updatedCategory.getName());
        categoryService.updateCatetory(category);
        return "redirect:/categories";
    }
}
