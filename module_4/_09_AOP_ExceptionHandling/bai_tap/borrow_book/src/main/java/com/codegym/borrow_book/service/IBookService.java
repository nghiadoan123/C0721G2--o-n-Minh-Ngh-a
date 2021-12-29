package com.codegym.borrow_book.service;

import com.codegym.borrow_book.model.Book;

import java.util.List;

public interface IBookService {

    List<Book> getAll();

    Book findById(Integer id);

    void save(Book book);

    List<Book> findByName(String name);

    void remove(Integer id);

}
