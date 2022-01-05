package com.codegym.blog_manager.controller;


import com.codegym.blog_manager.model.Blog;
import com.codegym.blog_manager.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blog")
@CrossOrigin(origins = "*")
public class BlogRestController {

    @Autowired
    private IBlogService iBlogService;


    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Blog>> showList(@RequestParam(name = "title", required = false) String title,
                                               @RequestParam(name = "offset", required = false) Integer offset){
        List<Blog> blogList = iBlogService.findByNameLimit(title,offset);
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

}
