package _12_java_collection_framework.exercise.product_manager;

import java.util.Comparator;

public class SortUpPrice implements Comparator<Product> {
    @Override
    public int compare(Product product1, Product product2) {
        if (product1.getPrice()>product2.getPrice()){
            return 1;
        }else if (product1.getPrice()<product2.getPrice()){
            return -1;
        }else {
            return 0;
        }
    }
}
