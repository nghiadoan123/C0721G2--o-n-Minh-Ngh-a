package com.codegym.repository;

import com.codegym.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    // tìm chính xác theo title
//    @Query(value = "select * from blog where title = :title",nativeQuery = true)
//    List<Blog> getByName(@Param("title")String title);


    // tìm gần đúng theo title
    @Query(value = "select * from blog where title like :title",nativeQuery = true)
    List<Blog> getByName(@Param("title")String title);

}
