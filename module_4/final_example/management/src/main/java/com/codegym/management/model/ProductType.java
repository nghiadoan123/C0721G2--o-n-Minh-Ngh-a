package com.codegym.management.model;


import javax.persistence.*;
import java.util.List;

@Entity(name = "product_type")
public class ProductType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_type_id")
    private int id;
    @Column(name = "product_type_name")
    private String name;


    @OneToMany(mappedBy = "productType", cascade = CascadeType.ALL)
    private List<Product> products;


    public ProductType() {
    }

    public ProductType(int id, String name, List<Product> products) {
        this.id = id;
        this.name = name;
        this.products = products;
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
