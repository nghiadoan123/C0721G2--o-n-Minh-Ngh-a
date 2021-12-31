package com.codegym.demo.service;

import com.codegym.demo.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService {


    List<Student> getAll();

    Student findById(String id);

    void save(Student student);

    List<Student> findByName(String name);

    void remove(String id);

    Page<Student> findAll(Pageable of);
}
