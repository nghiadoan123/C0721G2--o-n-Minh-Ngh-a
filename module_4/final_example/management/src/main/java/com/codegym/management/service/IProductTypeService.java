package com.codegym.management.service;

import com.codegym.management.model.Contract;
import com.codegym.management.model.ProductType;

import java.util.List;

public interface IProductTypeService {


    List<ProductType> getAll();

    ProductType findById(Integer id);

    void save(ProductType productType);

    List<ProductType> findByName(String name);

    void remove(Integer id);
}
