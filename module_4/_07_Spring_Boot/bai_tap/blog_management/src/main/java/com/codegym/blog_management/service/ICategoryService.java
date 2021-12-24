package com.codegym.blog_management.service;

import com.codegym.blog_management.model.Blog;
import com.codegym.blog_management.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {

    List<Category> findAll();

    Category findById(String id);

    void remove(String id);

    void save(Category category);

    Page<Category> findAllPage(PageRequest of);

    List<Category> findByName(String name);

}
