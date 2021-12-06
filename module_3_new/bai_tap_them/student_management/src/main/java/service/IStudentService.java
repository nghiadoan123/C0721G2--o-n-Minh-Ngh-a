package service;

import bean.Student;
import bean.StudentClass;

import java.util.List;
import java.util.Map;

public interface IStudentService {

    List<Student> findAll();
    Map<String,String> save(Student student);
    void remove(int id);
    Student findById(int id);
    Map<String,String> update(Student student);
    List<Student> findByName(String name);
    List<Student> sortByAverage();

    List<StudentClass> findAllClass();
}
