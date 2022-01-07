package com.codegym.blog_manager.controller;

import com.codegym.blog_manager.model.Blog;
import com.codegym.blog_manager.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/blog")
@CrossOrigin(origins = "*")
public class BlogRestController {
    @Autowired
    private IBlogService blogService;

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Blog>> showList(@RequestParam(name = "nameBlog", required = false) String name,
                                               @RequestParam(name = "index", required = false) Integer index) {
        List<Blog> blogList = blogService.searchByName(name, index);
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> addBlog(@RequestBody Blog blog){
        String s = "success";
        blogService.save(blog);
        return new ResponseEntity<>(s,HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteBlog(@RequestParam(name = "id",required = false) Integer id){
        String s = "success";
        blogService.deleteById(id);
        return new ResponseEntity<>(s,HttpStatus.OK);
    }
}
