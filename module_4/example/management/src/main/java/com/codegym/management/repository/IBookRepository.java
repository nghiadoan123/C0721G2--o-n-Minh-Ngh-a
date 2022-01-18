package com.codegym.management.repository;


import com.codegym.management.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookRepository extends JpaRepository<Book,Integer> {

    @Query(value= "select * from question where question.title like %:title%",nativeQuery = true)
    List<Book> findByName(@Param("title")String name);

    
}
