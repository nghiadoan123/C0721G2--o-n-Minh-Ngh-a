package com.codegym.blog_management.repository;


import com.codegym.blog_management.model.Blog;
import com.codegym.blog_management.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "iCategoryRepository")
public interface ICategoryRepository extends JpaRepository<Category,String> {

    @Query(value = "select * from category where name like :name",nativeQuery = true)
    List<Category> findByName(@Param("name") String name);
}
