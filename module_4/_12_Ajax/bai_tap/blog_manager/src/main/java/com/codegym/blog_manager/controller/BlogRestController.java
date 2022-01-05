package com.codegym.blog_manager.controller;


import com.codegym.blog_manager.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/blog")
@CrossOrigin(origins = "*")
public class BlogRestController {

    @Autowired
    @Qualifier("iBlogService")
    private IBlogService iBlogService;


    
}
