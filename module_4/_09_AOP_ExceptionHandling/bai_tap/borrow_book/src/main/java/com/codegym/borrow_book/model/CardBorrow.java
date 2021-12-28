package com.codegym.borrow_book.model;


import javax.persistence.*;
import java.util.Set;

@Entity
public class CardBorrow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_card_borrow")
    private Integer id;

    @Column(name = "code")
    private Integer codeBorrow;

    @OneToMany(mappedBy = "cardBorrow")
    private Set<Book> books;

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public CardBorrow() {
    }


    public CardBorrow(Integer id, Integer codeBorrow) {
        this.id = id;
        this.codeBorrow = codeBorrow;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCodeBorrow() {
        return codeBorrow;
    }

    public void setCodeBorrow(Integer codeBorrow) {
        this.codeBorrow = codeBorrow;
    }


}
