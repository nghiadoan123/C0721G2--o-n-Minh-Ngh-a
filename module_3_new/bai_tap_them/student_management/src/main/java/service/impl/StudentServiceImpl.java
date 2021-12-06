package service.impl;

import bean.Student;
import bean.StudentClass;
import repository.IStudentRepository;
import repository.impl.StudentRepositoryImpl;
import service.IStudentService;
import util.Validate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentServiceImpl implements IStudentService {

    IStudentRepository iStudentRepository = new StudentRepositoryImpl();

    @Override
    public List<Student> findAll() {
        return iStudentRepository.findAll();
    }

    @Override
    public  Map<String,String> save(Student student) {
        Map<String,String> messageList = new HashMap<>();
        Map<String,String> messageListRepo = this.iStudentRepository.save(student);
        if (!messageListRepo.isEmpty()){
            messageList.put("message",messageListRepo.get("message"));
        }
        if (!Validate.validateName(student.getName())){
            messageList.put("messageName","Invalid Name ex: Nguyen Văn A ");
        }
        if (student.getAge()>100 || student.getAge()<0){
            messageList.put("messageAge","Invalid Age age from 1-100");
        }
        if (student.getAverage()>10 || student.getAverage()<0){
            messageList.put("messageAverage","Invalid Average average from 1-10");
        }
        return messageList;
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
    public Map<String,String> update(Student student) {
        Map<String,String> messageList = new HashMap<>();
       Map<String,String> messageListRepo = iStudentRepository.update(student);

       if (!messageListRepo.isEmpty()){
           messageList.put("message",messageListRepo.get("message"));
       }
       if (!Validate.validateName(student.getName())){
           messageList.put("messageName","Invalid Name ex: Nguyen Văn A ");
       }
       if (student.getAge()>100 || student.getAge()<0){
           messageList.put("messageAge","Invalid Age age from 1-100");
       }
       if (student.getAverage()>10 || student.getAverage()<0){
           messageList.put("messageAverage","Invalid Average average from 1-10");
       }

       return messageList;
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
