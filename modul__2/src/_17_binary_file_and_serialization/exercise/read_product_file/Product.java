package _17_binary_file_and_serialization.exercise.read_product_file;

import java.io.Serializable;

public class Product implements Serializable {
    private String productId;
    private String productName;
    private String manufacture;
    private double price;

    public Product() {
    }

    public Product(String productId, String productName, String manufacture, double price) {
        this.productId = productId;
        this.productName = productName;
        this.manufacture = manufacture;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", manufacture='" + manufacture + '\'' +
                ", price=" + price +
                '}';
    }
}
