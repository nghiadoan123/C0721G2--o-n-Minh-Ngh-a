package service;

import bean.Student;

import java.util.List;

public interface IStudentService {

    List<Student> findAll();
    void save(Student student);
    void remove(int id);
    Student findById(int id);
    void update(Student student);
    List<Student> findByName(String name);
    List<Student> sortByAverage();

}
