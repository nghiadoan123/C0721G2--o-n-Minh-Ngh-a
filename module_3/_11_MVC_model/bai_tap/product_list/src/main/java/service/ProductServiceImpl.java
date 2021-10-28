package service;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService{

    private static Map<Integer,Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1,"iphone",125.5,"iphone6","apple"));
        products.put(2, new Product(2,"iphone",125.5,"iphone7","apple"));
        products.put(3, new Product(3,"iphone",158.25,"iphone8","apple"));
        products.put(4, new Product(4,"iphone",500.245,"iphone9","apple"));
        products.put(5, new Product(5,"nokia",289.36,"nokia9","apple"));
        products.put(6, new Product(6,"nokia",273.53,"nokia5","apple"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getProductId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
