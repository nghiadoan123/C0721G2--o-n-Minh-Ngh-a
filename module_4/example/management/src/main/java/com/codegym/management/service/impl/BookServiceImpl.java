package com.codegym.management.service.impl;


import com.codegym.management.model.Book;
import com.codegym.management.repository.IBookRepository;
import com.codegym.management.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements IBookService {
    @Autowired
    private IBookRepository iBookRepository;


    @Override
    public List<Book> getAll() {
        return iBookRepository.findAll();
    }

    @Override
    public Book findById(Integer id) {
        return iBookRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Book book) {
        iBookRepository.save(book);
    }

    @Override
    public List<Book> findByName(String name) {
        return iBookRepository.findByName(name);
    }

    @Override
    public void remove(Integer id) {
        iBookRepository.deleteById(id);
    }

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return iBookRepository.findAll(pageable);
    }

    @Override
    public List<Book> findByNameTwo(String name, String code) {
        return null;
    }

    @Override
    public List<Book> findByCode(String code) {
        return null;
    }


}
