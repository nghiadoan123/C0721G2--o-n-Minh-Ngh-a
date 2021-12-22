package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements IProductRepository {
    @Override
    public List<Product> findAll() {
        List<Product> productList = BaseRepository.entityManager
                .createQuery("select p from product as p", Product.class).getResultList();
        return productList;
    }

    @Override
    public void save(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        Product product1 = new Product();
        product1.setId(product.getId());
        product1.setName(product.getName());
        product1.setPrice(product.getPrice());
        product1.setDescription(product.getDescription());
        product1.setProducer(product.getProducer());
        BaseRepository.entityManager.persist(product1);
        // hoặc chỉ cần dùng dòng lênh    BaseRepository.entityManager.persist(product1); thôi cũng dược
        entityTransaction.commit();
    }

    @Override
    public Product findById(int id) {
        // cách 1
        Product product = BaseRepository.entityManager
                .createQuery("select p from product p where p.id = :id", Product.class)
                .setParameter("id", id)
                .getSingleResult();
        return product;
        // cách 2
//        return BaseRepository.entityManager.find(Product.class, id);
    }

    @Override
    public void update(int id, Product product) {
        try {
            EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
            entityTransaction.begin();
            // cách 1
//            Product product1 = findById(product.getId());
            // cách 2
            Product product1 = BaseRepository.entityManager
                    .createQuery("select p from product p where p.id = :id", Product.class)
                    .setParameter("id", id)
                    .getSingleResult();
            product1.setId(product.getId());
            product1.setName(product.getName());
            product1.setPrice(product.getPrice());
            product1.setDescription(product.getDescription());
            product1.setProducer(product.getProducer());
            BaseRepository.entityManager.persist(product1);
            entityTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(int id) {

        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        Product product1 = null;
        product1 = findById(id);
        BaseRepository.entityManager.remove(product1);
        entityTransaction.commit();
    }

    @Override
    public List<Product> searchName(String name) {
        List<Product> list = BaseRepository.entityManager
                // cách khai báo 1:  ?1 khai báo theo dấu hỏi và vị trí tham số
//                .createQuery("select p from product p where p.name = ?1" , Product.class)
//                .setParameter(1,name)
//                .getResultList();
                // cách khai báo 2 sử dụng =: param
                .createQuery("select p from product p where p.name = :nameOfProduct", Product.class)
                .setParameter("nameOfProduct", name)
                .getResultList();
        return list;
    }
}
