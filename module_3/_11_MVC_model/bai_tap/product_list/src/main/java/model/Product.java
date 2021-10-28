package model;

public class Product {

    private int productId;
    private String productName;
    private double productPrice;
    private String productDescription;
    private String productManage;

    public Product() {
    }

    public Product(int productId, String productName, double productPrice, String productDescription, String productManage) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.productManage = productManage;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductManage() {
        return productManage;
    }

    public void setProductManage(String productManage) {
        this.productManage = productManage;
    }
}
