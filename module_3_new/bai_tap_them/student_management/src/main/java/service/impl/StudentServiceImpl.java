package service.impl;

import bean.Student;
import bean.StudentClass;
import repository.IStudentRepository;
import repository.impl.StudentRepositoryImpl;
import service.IStudentService;

import java.util.List;

public class StudentServiceImpl implements IStudentService {

    IStudentRepository iStudentRepository = new StudentRepositoryImpl();

    @Override
    public List<Student> findAll() {
        return iStudentRepository.findAll();
    }

    @Override
    public void save(Student student) {
        iStudentRepository.save(student);
    }

    @Override
    public void remove(int id) {
        iStudentRepository.remove(id);
    }

    @Override
    public Student findById(int id) {
        return iStudentRepository.findById(id);
    }

    @Override
    public void update(Student student) {
        iStudentRepository.update(student);
    }

    @Override
    public List<Student> findByName(String name) {
        return iStudentRepository.findByName(name);
    }

    @Override
    public List<Student> sortByAverage() {
        return iStudentRepository.sortByAverage();
    }

    @Override
    public List<StudentClass> findAllClass() {
        return iStudentRepository.findAllClass();
    }

}
