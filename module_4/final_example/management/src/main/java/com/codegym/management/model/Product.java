package com.codegym.management.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int id;
    @Column(name = "product_name")
    private String name;
    @Column(name = "product_price")
    private double price;
    @Column(name = "status_product")
    private String statusProduct;


    @ManyToOne
    @JoinColumn(name = "product_type_id", referencedColumnName = "product_type_id")
    private ProductType productType;


    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Contract> contracts;

    public Product() {
    }

    public Product(int id, String name, double price, String statusProduct, ProductType productType, List<Contract> contracts) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.statusProduct = statusProduct;
        this.productType = productType;
        this.contracts = contracts;
    }

    public Product(int id, String name, double price, String statusProduct, ProductType productType) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.statusProduct = statusProduct;
        this.productType = productType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatusProduct() {
        return statusProduct;
    }

    public void setStatusProduct(String statusProduct) {
        this.statusProduct = statusProduct;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}
