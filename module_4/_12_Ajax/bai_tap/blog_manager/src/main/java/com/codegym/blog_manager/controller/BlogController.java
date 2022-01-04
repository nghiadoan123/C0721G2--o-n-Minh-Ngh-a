package com.codegym.blog_manager.controller;


import com.codegym.blog_manager.model.Blog;
import com.codegym.blog_manager.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RestController
@RequestMapping("/blog")
public class BlogController {


    @Autowired
    @Qualifier("iBlogService")
    private IBlogService iBlogService;

    @GetMapping
    public ResponseEntity<List<Blog>> findAllBlog() {
        List<Blog> blogs =iBlogService.getAll();
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ModelAndView getAllBlog() {
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("blogList", iBlogService.getAll());
        return modelAndView;
    }

//    @GetMapping(value = "/page")
//    public ResponseEntity<Page<Blog>> pageList(@PageableDefault(value = 2) Pageable pageable){
//        Page<Blog> blogPage = iBlogService.findAll(pageable);
//        if (blogPage.isEmpty()){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(blogPage,HttpStatus.OK);
//    }


    @GetMapping(value = "/page")
    public ModelAndView pageList(@PageableDefault(value = 2) Pageable pageable){
        Page<Blog> blogPage = iBlogService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("list");
         modelAndView.addObject("blogList",blogPage);
         return modelAndView;
    }



    @GetMapping("/{id}")
    public ResponseEntity<Blog> findBlogById(@PathVariable Integer id) {
        Blog  blog = iBlogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @GetMapping("search/{title}")
    public ModelAndView search(@PathVariable(value = "title") String title){
        List<Blog> blogList = iBlogService.findByName(title);
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("blogList",blogList);
        return modelAndView;
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Blog> saveBlog(@RequestBody Blog blog) {
        if (blog == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iBlogService.save(blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable Integer id, @RequestBody Blog blog) {
        Blog blog1 = iBlogService.findById(id);
        if (blog1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blog.setId(blog1.getId());
        iBlogService.save(blog);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Blog> deleteBlog(@PathVariable Integer id) {
       Blog blog = iBlogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iBlogService.remove(id);
        return new ResponseEntity<>(blog,HttpStatus.NO_CONTENT);
    }

}
