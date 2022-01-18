package com.codegym.management.service.impl;


import com.codegym.management.model.BookType;
import com.codegym.management.repository.IBookTypeRepository;
import com.codegym.management.service.IBookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookTypeServiceImpl implements IBookTypeService {
    @Autowired
    private IBookTypeRepository iBookTypeRepository;


    @Override
    public List<BookType> getAll() {
        return iBookTypeRepository.findAll();
    }

    @Override
    public BookType findById(Integer id) {
        return iBookTypeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(BookType bookType) {

    }

    @Override
    public List<BookType> findByName(String name) {
        return null;
    }

    @Override
    public void remove(Integer id) {

    }
}
