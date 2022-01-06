package com.codegym.blog_manager.controller;


import com.codegym.blog_manager.service.impl.BlogService;
import com.codegym.blog_manager.service.impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping({"/", "/blog"})
@CrossOrigin(origins = "*")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping()
    public ModelAndView showAll() {
        return new ModelAndView("blog/list", "blogList", blogService.findAll());
    }
}
