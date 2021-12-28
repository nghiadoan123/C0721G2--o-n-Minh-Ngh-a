package com.codegym.borrow_book.service.impl;

import com.codegym.borrow_book.model.Book;
import com.codegym.borrow_book.model.CardBorrow;
import com.codegym.borrow_book.repository.IBookRepository;
import com.codegym.borrow_book.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class BookServiceImpl implements IBookService {
    @Autowired
    IBookRepository iBookRepository;

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
        return iBookRepository.getByName("%" + name + "%");
    }

    @Override
    public void remove(Integer id) {
        iBookRepository.deleteById(id);
    }
}
