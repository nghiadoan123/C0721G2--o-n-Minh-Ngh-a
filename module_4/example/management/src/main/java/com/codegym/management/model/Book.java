package com.codegym.management.model;


import javax.persistence.*;

@Entity(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "questions")
    private String questions;
    @Column(name = "date_create")
    private String dateCreate;
    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "book_type_id", referencedColumnName = "book_type_id")
    private BookType bookType;


    public Book() {
    }

    public Book(int id, String title, String questions, String dateCreate, String status, BookType bookType) {
        this.id = id;
        this.title = title;
        this.questions = questions;
        this.dateCreate = dateCreate;
        this.status = status;
        this.bookType = bookType;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String question) {
        this.questions = question;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }
}
