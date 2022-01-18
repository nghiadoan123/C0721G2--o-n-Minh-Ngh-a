package com.codegym.management.service;

import com.codegym.management.model.BookType;

import java.util.List;

public interface IBookTypeService {

    List<BookType> getAll();

    BookType findById(Integer id);

    void save(BookType bookType);

    List<BookType> findByName(String name);

    void remove(Integer id);
}
