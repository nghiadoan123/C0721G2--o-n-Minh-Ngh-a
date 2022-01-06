package com.codegym.blog_manager.service;


import com.codegym.blog_manager.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface ICategoryService {

    List<Category> findAll();
    void save(Category category);
    void deleteById(Integer id);
    Category findById(Integer id);

}
