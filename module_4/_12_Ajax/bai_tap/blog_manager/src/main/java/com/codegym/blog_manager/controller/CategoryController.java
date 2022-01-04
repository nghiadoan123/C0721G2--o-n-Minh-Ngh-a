package com.codegym.blog_manager.controller;
import com.codegym.blog_manager.model.Blog;
import com.codegym.blog_manager.model.Category;
import com.codegym.blog_manager.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    @Qualifier("iCateGoryService")
    ICategoryService iCategoryService;

    @GetMapping
    public ResponseEntity<List<Category>> findAllCategory() {
        List<Category> categoryList =iCategoryService.findAll();
        if (categoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findCategoryById(@PathVariable Integer id) {
        Category  category = iCategoryService.findById(id);
        if (category == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable Integer id, @RequestBody Category category) {
        Category category1 = iCategoryService.findById(id);
        if (category1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        category.setId(category1.getId());
        iCategoryService.save(category);
        return new ResponseEntity<>( HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Category> saveCategory(@RequestBody Category category) {
        if (category == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iCategoryService.save(category);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable Integer id) {
        Category category = iCategoryService.findById(id);
        if (category == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iCategoryService.remove(id);
        return new ResponseEntity<>(category,HttpStatus.OK);
    }

}
