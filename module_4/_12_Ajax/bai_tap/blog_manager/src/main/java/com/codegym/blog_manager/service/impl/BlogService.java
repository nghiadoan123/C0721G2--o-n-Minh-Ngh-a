package com.codegym.blog_manager.service.impl;

import com.codegym.blog_manager.model.Blog;
import com.codegym.blog_manager.repository.IBlogRepository;
import com.codegym.blog_manager.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BlogService implements IBlogService {

    @Autowired
    IBlogRepository iBlogRepository;


    @Override
    public Blog findById(Integer id) {
        return iBlogRepository.findById(id).orElse(null);
    }

    @Override
    public List<Blog> searchByName(String name, int offset) {
        return iBlogRepository.searchByName("%"+name+"%",offset);
    }

    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        //Thêm mới và cập nhật đều dùng save.
        // Nhưng nếu student không có id thì thêm mới -> có id tồn tại trong DB thì sẽ thành cập nhật
        iBlogRepository.save(blog);
    }

    @Override
    public void deleteById(Integer id) {
        iBlogRepository.deleteById(id);
    }

}
