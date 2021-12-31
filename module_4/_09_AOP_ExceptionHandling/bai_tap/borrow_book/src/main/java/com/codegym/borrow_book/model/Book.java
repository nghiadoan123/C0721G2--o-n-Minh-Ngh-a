package com.codegym.borrow_book.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @NotBlank(message = "not blank")
    @Column(name = "name_book")
    private String name;
    @NotBlank(message = "not blank")
    @Column(name = "title")
    private String title;
    @Column(name = "number")
    @NotNull(message = "not null")
    @Min(value = 0,message = "number must be larger zero")
    @Max(value = 999999)
    private Integer number;


    @OneToMany(mappedBy = "book", cascade = CascadeType.REMOVE)
    private Set<CardBorrow> cardBorrows;

    public Set<CardBorrow> getCardBorrows() {
        return cardBorrows;
    }

    public void setCardBorrows(Set<CardBorrow> cardBorrows) {
        this.cardBorrows = cardBorrows;
    }



    public Book() {
    }

    public Book(Integer id, String name, String title, Integer number) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.number = number;
    }


        public Book(Integer id, String name, String title, Integer number, Set<CardBorrow> cardBorrows) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.number = number;
        this.cardBorrows = cardBorrows;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
