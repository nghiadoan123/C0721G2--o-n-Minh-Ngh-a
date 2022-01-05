package com.codegym.blog_manager.repository;

import com.codegym.blog_manager.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "iBlogRepository")
public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    // tìm chính xác theo title
//    @Query(value = "select * from blog where title = :title",nativeQuery = true)
//    List<Blog> getByName(@Param("title")String title);


    // tìm gần đúng theo title
    @Query(value = "select * from blog where title like :title ",nativeQuery = true)
    List<Blog> getByName(@Param("title")String title);


//    @Query(value = "select * from blog where title like :title & LIMIT :offset , 2;",nativeQuery = true)
//    List<Blog> getByNameLimit(@Param("title")String title, @Param("offset") Integer offset);

    @Query(value ="SELECT * FROM blog WHERE title like concat('%', ?1, '%') LIMIT ?2 , 2;", nativeQuery=true)
    List<Blog> getByNameLimit(String title,Integer offset);
}
