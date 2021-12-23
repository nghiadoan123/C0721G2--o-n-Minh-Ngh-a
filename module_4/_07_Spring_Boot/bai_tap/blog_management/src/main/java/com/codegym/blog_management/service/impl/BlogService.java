package com.codegym.blog_management.service.impl;

import com.codegym.blog_management.model.Blog;
import com.codegym.blog_management.repository.IBlogRepository;
import com.codegym.blog_management.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service(value = "iBlogService")
public class BlogService implements IBlogService {

    @Autowired
    @Qualifier("iBlogRepository")
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
        // tìm gần đúng theo tên
        return iBlogRepository.getByName("%" + name + "%");
        // tìm chính xác theo tên
//        return iBlogRepository.getByName(name);
    }

    @Override
    public void remove(Integer id) {
        iBlogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> findAll(Pageable of) {
        return iBlogRepository.findAll(of);
    }
}
