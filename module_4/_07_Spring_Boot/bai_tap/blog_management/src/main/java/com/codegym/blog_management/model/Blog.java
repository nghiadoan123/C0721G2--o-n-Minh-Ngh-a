package com.codegym.blog_management.model;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "blog")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "title")
    String title;
    @Column(name = "content")
    String content;

    @Column(name = "date_create",columnDefinition = "DATE")
    String dateCreate;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Blog() {
    }

    public Blog(Integer id, String title, String content, String dateCreate, Category category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.dateCreate = dateCreate;
        this.category = category;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
