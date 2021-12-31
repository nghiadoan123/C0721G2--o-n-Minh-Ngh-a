package com.codegym.blog_manager.controller;


import com.codegym.blog_manager.model.Blog;
import com.codegym.blog_manager.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


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


    @GetMapping("/{id}")
    public ResponseEntity<Blog> findBlogById(@PathVariable Integer id) {
        Blog  blog = iBlogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Blog> saveBlog(@RequestBody Blog blog) {
        if (blog == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iBlogService.save(blog);
        return new ResponseEntity<>(HttpStatus.CREATED);
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
