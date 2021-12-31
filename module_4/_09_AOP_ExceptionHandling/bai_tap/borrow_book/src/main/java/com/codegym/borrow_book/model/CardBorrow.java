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


    @ManyToOne
    @JoinColumn(name = "id")
    private Book book;


    public CardBorrow() {
    }

    public CardBorrow(Integer id, Integer codeBorrow, Book book) {
        this.id = id;
        this.codeBorrow = codeBorrow;
        this.book = book;
    }

    public CardBorrow(Integer id, Integer codeBorrow) {
        this.id = id;
        this.codeBorrow = codeBorrow;
    }

        public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
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
