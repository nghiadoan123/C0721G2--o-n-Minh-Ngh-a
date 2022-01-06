package com.codegym.blog_manager.repository;

import com.codegym.blog_manager.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    @Query(value ="SELECT * FROM blog WHERE blog.name like concat('%', ?1, '%') LIMIT ?2 , 2;", nativeQuery=true)
    List<Blog> searchByName(@Param("name") String name, int offset);
}
