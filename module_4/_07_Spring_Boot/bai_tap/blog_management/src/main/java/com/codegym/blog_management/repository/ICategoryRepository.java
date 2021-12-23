package com.codegym.blog_management.repository;


import com.codegym.blog_management.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "iCategoryRepository")
public interface ICategoryRepository extends JpaRepository<Category,String> {

}
