package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import com.codegym.service.IProductService;

import java.util.*;

public class ProductRepositoryImpl implements IProductRepository {

    private static final Map<Integer,Product> productList = new HashMap<>();
    static {
        productList.put(1,new Product(1,"Iphone",30,"Iphone 6","USA"));
        productList.put(2,new Product(2,"Nokia",30,"Nokia 6","Indonexia"));
        productList.put(2,new Product(3,"Sam Sung",30,"Sam Sung 6","Philippin"));
        productList.put(4,new Product(4,"LG",30,"LG 6","Viet Nam"));
        productList.put(5,new Product(5,"Oppo",30,"Oppo 7","England"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productList.values());
    }

    @Override
    public void save(Product product) {
        productList.put(product.getId(),product);
    }

    @Override
    public Product findById(int id) {
        return productList.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productList.put(id,product);
    }

    @Override
    public void remove(int id) {
        productList.remove(id);
    }

    @Override
    public List<Product> searchName(String name) {
//        List<Product> products = new ArrayList<>();
//        Set<Integer> ketSet = productList.keySet();
//        for (Integer key: ketSet) {
//            if (productList.get(key).getName().contains(name)){
//                products.add(productList.get(key));
//            }
//        }
//        return products;

        List<Product> list = new ArrayList<>();
        for (Map.Entry<Integer,Product> stringEntry: productList.entrySet()) {
            if (stringEntry.getValue().getName().equals(name)){
                list.add(stringEntry.getValue());
            }
        }
        return list;
    }
}
