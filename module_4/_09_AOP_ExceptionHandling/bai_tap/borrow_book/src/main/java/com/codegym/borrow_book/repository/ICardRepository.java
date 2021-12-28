package com.codegym.borrow_book.repository;

import com.codegym.borrow_book.model.CardBorrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICardRepository extends JpaRepository<CardBorrow,Integer> {
}
