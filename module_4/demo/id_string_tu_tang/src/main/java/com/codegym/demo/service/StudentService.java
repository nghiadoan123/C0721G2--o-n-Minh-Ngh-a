package com.codegym.demo.service;

import com.codegym.demo.model.Student;
import com.codegym.demo.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService{

    @Autowired
    IStudentRepository iStudentRepository;


    @Override
    public List<Student> getAll() {
        return iStudentRepository.findAll();
    }

    @Override
    public Student findById(String id) {
        return iStudentRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Student student) {
        iStudentRepository.save(student);
    }

    @Override
    public List<Student> findByName(String name) {
        return null;
    }

    @Override
    public void remove(String id) {
        iStudentRepository.deleteById(id);
    }

    @Override
    public Page<Student> findAll(Pageable of) {
        return null;
    }
}
