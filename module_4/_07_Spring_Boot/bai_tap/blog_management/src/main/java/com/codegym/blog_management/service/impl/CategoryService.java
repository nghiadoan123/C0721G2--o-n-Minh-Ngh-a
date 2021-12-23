package com.codegym.blog_management.service.impl;

import com.codegym.blog_management.model.Category;
import com.codegym.blog_management.repository.ICategoryRepository;
import com.codegym.blog_management.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "iCateGoryService")
public class CategoryService implements ICategoryService {
    @Autowired
    @Qualifier("iCategoryRepository")
    ICategoryRepository iCategoryRepository;

    @Override
    public List<Category> findAll() {
        return iCategoryRepository.findAll();
    }
}
