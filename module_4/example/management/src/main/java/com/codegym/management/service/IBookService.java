package com.codegym.management.service;

import com.codegym.management.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBookService {

    List<Book> getAll();

    Book findById(Integer id);

    void save(Book book);

    List<Book> findByName(String name);

    void remove(Integer id);

    Page<Book> findAll(Pageable pageable);

    List<Book> findByNameTwo(String name, String code);

    List<Book> findByCode(String code);

}
