package repository;

import bean.Product;

import java.util.List;

public interface IProductRepository {

    List<Product> findAll();

    void save(Product customer);

    Product findById(int id);


    void update(int id, Product customer);

    void remove(int id);

    List<Product> searchByName(String name);
}
