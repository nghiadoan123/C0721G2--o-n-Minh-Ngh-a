package com.codegym.service;

import com.codegym.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogService {

    List<Blog> getAll();

    Blog findById(Integer id);

    void save(Blog blog);

    List<Blog> findByName(String name);

    void remove(Integer id);
}
