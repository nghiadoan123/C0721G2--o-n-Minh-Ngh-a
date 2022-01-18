package com.codegym.management.service.impl;


import com.codegym.management.model.ProductType;
import com.codegym.management.repository.IProductTypeRepository;
import com.codegym.management.service.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeServiceImpl implements IProductTypeService {

    @Autowired
    private IProductTypeRepository iProductTypeRepository;

    @Override
    public List<ProductType> getAll() {
        return iProductTypeRepository.findAll();
    }

    @Override
    public ProductType findById(Integer id) {
        return iProductTypeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(ProductType productType) {

    }

    @Override
    public List<ProductType> findByName(String name) {
        return null;
    }

    @Override
    public void remove(Integer id) {

    }
}
