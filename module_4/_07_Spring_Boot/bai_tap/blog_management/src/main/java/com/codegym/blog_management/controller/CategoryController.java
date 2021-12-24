package com.codegym.blog_management.controller;


import com.codegym.blog_management.model.Blog;
import com.codegym.blog_management.model.Category;
import com.codegym.blog_management.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    @Qualifier("iCateGoryService")
    ICategoryService iCategoryService;

    @GetMapping({"", "/list"})
    public String showList(Model model, @RequestParam(value = "page" ,defaultValue = "0") int pageList) {
//        List<Category> categoryList = iCategoryService.findAll();
//        model.addAttribute("categoryList", categoryList);
        Page<Category> categoryList = iCategoryService.findAllPage(PageRequest.of(pageList,2));
        model.addAttribute("categoryList", categoryList);
        return "category/index";
    }

    @GetMapping("/view")
    public String view(@RequestParam("id") String id, Model model) {
        Category category = iCategoryService.findById(id);
        model.addAttribute("category", category);
        return "category/view";
    }

    @GetMapping("/delete")
    public String showDelete(@RequestParam(name = "id") String id, Model model) {
        model.addAttribute("category", iCategoryService.findById(id));
        return "category/delete";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute("category") Category category, RedirectAttributes redirectAttributes) {
        iCategoryService.remove(category.getId());
        redirectAttributes.addFlashAttribute("message", "Removed product successfully!");
        return "redirect:/category/list";
    }

    @GetMapping("{id}/edit")
    public String showEdit(@PathVariable(name = "id") String id, Model model) {
        model.addAttribute("category", iCategoryService.findById(id));
        return "category/edit";
    }


    @GetMapping("/edit_param")
    public String showEditParam(@RequestParam(name = "id") String id, Model model) {
        model.addAttribute("category", iCategoryService.findById(id));
        return "category/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("blog") Category category, Model model, RedirectAttributes redirectAttributes) {
        iCategoryService.save(category);
        redirectAttributes.addFlashAttribute("message", "Edit success");
        return "redirect:/category/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("category", new Category());
        return "category/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("category") Category category, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", "Create success");
        iCategoryService.save(category);
        return "redirect:/category/list";
    }


    @GetMapping("/search")
    public String search(@RequestParam(name = "name") String name, Model model) {
        List<Category> categoryList = iCategoryService.findByName(name);
        model.addAttribute("categoryList", categoryList);
        return "category/search_list";
    }

}
