package com.codegym.borrow_book.repository;

import com.codegym.borrow_book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookRepository extends JpaRepository<Book,Integer> {

    // tìm gần đúng theo title
    @Query(value = "select * from book where name_book like :name",nativeQuery = true)
    List<Book> getByName(@Param("name")String name);


}
