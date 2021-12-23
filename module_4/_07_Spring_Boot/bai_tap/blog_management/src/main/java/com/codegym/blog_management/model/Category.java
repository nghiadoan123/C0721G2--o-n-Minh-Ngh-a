package com.codegym.blog_management.model;


import javax.persistence.*;
import java.util.Set;

@Entity(name = "category")
public class Category {

    @Id
    @Column( name = "id_category")
    String id;
    @Column( name = "name")
    String name;

    @OneToMany(mappedBy = "category",cascade = CascadeType.REMOVE)
    private Set<Blog> blogs;

    public Set<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(Set<Blog> blogs) {
        this.blogs = blogs;
    }

    public Category() {
    }

    public Category(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
