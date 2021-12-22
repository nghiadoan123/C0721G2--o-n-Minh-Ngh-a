package com.codegym.service.impl;

import com.codegym.model.Blog;
import com.codegym.repository.IBlogRepository;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BlogService implements IBlogService {

    @Autowired
    IBlogRepository iBlogRepository;

    @Override
    public List<Blog> getAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public Blog findById(Integer id) {
        return iBlogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        //Thêm mới và cập nhật đều dùng save.
        // Nhưng nếu student không có id thì thêm mới -> có id tồn tại trong DB thì sẽ thành cập nhật
        iBlogRepository.save(blog);
    }

    @Override
    public List<Blog> findByName(String name) {
        return iBlogRepository.getByName("%"+name+"%");
    }

    @Override
    public void remove(Integer id) {
        iBlogRepository.deleteById(id);
    }
}
