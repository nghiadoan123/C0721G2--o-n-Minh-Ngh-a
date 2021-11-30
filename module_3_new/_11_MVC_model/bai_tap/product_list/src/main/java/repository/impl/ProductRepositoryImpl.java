package repository.impl;

import bean.Product;
import repository.IProductRepository;

import java.util.*;

public class ProductRepositoryImpl implements IProductRepository {

    private static Map<Integer,Product> productMap;

    static {
        productMap = new HashMap<>();
        productMap.put(1, new Product(1,"iphone",125.5,"iphone6","apple"));
        productMap.put(2, new Product(2,"iphone",125.5,"iphone7","apple"));
        productMap.put(3, new Product(3,"iphone",158.25,"iphone8","apple"));
        productMap.put(4, new Product(4,"iphone",500.245,"iphone9","apple"));
        productMap.put(5, new Product(5,"nokia",289.36,"nokia9","apple"));
        productMap.put(6, new Product(6,"nokia",273.53,"nokia5","apple"));
    }



    @Override
    public List<Product> findAll() {
        return new LinkedList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getProductId(),product);
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id,product);
    }

    @Override
    public void remove(int id) {
        productMap.remove(id);
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> listAll = findAll();
        List<Product> searchList = new ArrayList<>();
        for (Product product:listAll) {
            if(product.getProductName().toLowerCase().contains(name)){
                searchList.add(product);
            }
        }
        return searchList;
    }

}
