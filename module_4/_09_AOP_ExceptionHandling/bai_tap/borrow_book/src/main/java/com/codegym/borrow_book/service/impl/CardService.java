package com.codegym.borrow_book.service.impl;


import com.codegym.borrow_book.model.CardBorrow;
import com.codegym.borrow_book.repository.ICardRepository;
import com.codegym.borrow_book.service.ICardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService implements ICardService {
    @Autowired
    ICardRepository iCardRepository;
    @Override
    public List<CardBorrow> getAll() {
        return iCardRepository.findAll();
    }

    @Override
    public CardBorrow findById(Integer id) {
        return iCardRepository.findById(id).orElse(null);
    }

    @Override
    public void save(CardBorrow cardBorrow) {
        iCardRepository.save(cardBorrow);
    }

    @Override
    public List<CardBorrow> findByName(String name) {
        return null;
    }

    @Override
    public void remove(Integer id) {

    }
}
