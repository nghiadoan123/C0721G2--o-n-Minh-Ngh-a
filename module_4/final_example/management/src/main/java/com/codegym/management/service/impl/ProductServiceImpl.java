package com.codegym.management.service.impl;


import com.codegym.management.model.Product;
import com.codegym.management.repository.IProductRepository;
import com.codegym.management.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductRepository iProductRepository;


    @Override
    public List<Product> getAll() {
        return iProductRepository.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return iProductRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public List<Product> findByName(String name) {
        return null;
    }

    @Override
    public void remove(Integer id) {
        iProductRepository.deleteById(id);
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return iProductRepository.findAll(pageable);
    }

    @Override
    public List<Product> findByNameTwo(String name, String code) {
        return null;
    }

    @Override
    public List<Product> findByCode(String code) {
        return null;
    }
}
