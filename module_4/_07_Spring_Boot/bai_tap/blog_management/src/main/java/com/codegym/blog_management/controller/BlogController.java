package com.codegym.blog_management.controller;

import com.codegym.blog_management.model.Blog;
import com.codegym.blog_management.service.IBlogService;
import com.codegym.blog_management.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    @Qualifier("iBlogService")
    IBlogService iBlogService;

    @Autowired
    @Qualifier("iCateGoryService")
    ICategoryService iCategoryService;

//    @GetMapping({"","/list"})
//    public String showList(Model model) {
//        List<Blog> blogList = iBlogService.getAll();
//        model.addAttribute("blogList", blogList);
//        return "blog/index";
//    }

    @GetMapping(value = {"","/list"})
    public String listPageable(Model model, @RequestParam(value = "page", defaultValue = "0")int page) {
        // nhớ viết theo tên thuộc tính trong class
        Sort sort = Sort.by("dateCreate").descending().and(Sort.by("id").ascending());
        Page<Blog> blogPage = iBlogService.findAll(PageRequest.of(page,3,sort));
        model.addAttribute("blogPage", blogPage);
        return "blog/index";
    }


    @GetMapping("{id}/view")
    public String view(@PathVariable("id") Integer id, Model model) {
        Blog blog = iBlogService.findById(id);
        model.addAttribute("blog", blog);
        return "blog/view";
    }

    @GetMapping("{id}/delete")
    public String showDelete(@PathVariable(name = "id") int id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        return "blog/delete";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.remove(blog.getId());
        redirectAttributes.addFlashAttribute("message", "Removed product successfully!");
        return "redirect:/blog/list";
    }


    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categoryList",iCategoryService.findAll());
        return "blog/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", "Create success");
        iBlogService.save(blog);
        return "redirect:/blog/list";
    }


    @GetMapping("{id}/edit")
    public String showEdit(@PathVariable(name = "id") int id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        model.addAttribute("categoryList",iCategoryService.findAll());
        return "blog/edit";
    }


    @GetMapping("/edit_param")
    public String showEditParam(@RequestParam(name = "id") int id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        model.addAttribute("categoryList",iCategoryService.findAll());
        return "blog/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("blog") Blog blog, Model model, RedirectAttributes redirectAttributes) {
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Edit success");
        return "redirect:/blog/list";
    }

    @GetMapping("/search")
    public String search(@RequestParam(name = "name") String name, Model model) {
        List<Blog> blogList = iBlogService.findByName(name);
        model.addAttribute("blogList", blogList);
        return "blog/search_list";
    }
}
