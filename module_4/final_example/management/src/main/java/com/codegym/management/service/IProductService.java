package com.codegym.management.service;

import com.codegym.management.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {


    List<Product> getAll();

    Product findById(Integer id);

    void save(Product product);

    List<Product> findByName(String name);

    void remove(Integer id);

    Page<Product> findAll(Pageable pageable);

    List<Product> findByNameTwo(String name, String code);

    List<Product> findByCode(String code);
}
