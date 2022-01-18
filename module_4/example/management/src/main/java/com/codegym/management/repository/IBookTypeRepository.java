package com.codegym.management.repository;


import com.codegym.management.model.BookType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookTypeRepository extends JpaRepository<BookType,Integer> {
}
