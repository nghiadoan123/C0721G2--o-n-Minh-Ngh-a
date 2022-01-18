package com.codegym.management.model;


import javax.persistence.*;
import java.util.List;

@Entity(name = "book_type")
public class BookType {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_type_id")
    private int id;
    @Column(name = "type_name")
    private String name;

    @OneToMany(mappedBy = "bookType", cascade = CascadeType.ALL)
    private List<Book> books;



    public BookType() {
    }

    public BookType(int id, String name, List<Book> books) {
        this.id = id;
        this.name = name;
        this.books = books;
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

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
