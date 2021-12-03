package repository;

import bean.Student;
import bean.StudentClass;

import java.util.List;

public interface IStudentRepository {

    List<Student> findAll();
    void save(Student student);
    void remove(int id);
    Student findById(int id);
    void update(Student student);
    List<Student> findByName(String name);
    List<Student> sortByAverage();

    List<StudentClass> findAllClass();


}
