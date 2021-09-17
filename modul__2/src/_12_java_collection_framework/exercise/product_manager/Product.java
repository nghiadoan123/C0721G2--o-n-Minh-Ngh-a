package _12_java_collection_framework.exercise.product_manager;



public class Product {
    private int id;
    private String productName;
    private String descriptionProduct;
    private double price;

    public Product() {
    }

    public Product(int id, String productName, String descriptionProduct, double price) {
        this.id = id;
        this.productName = productName;
        this.descriptionProduct = descriptionProduct;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescriptionProduct() {
        return descriptionProduct;
    }

    public void setDescriptionProduct(String descriptionProduct) {
        this.descriptionProduct = descriptionProduct;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", descriptionProduct='" + descriptionProduct + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

}
