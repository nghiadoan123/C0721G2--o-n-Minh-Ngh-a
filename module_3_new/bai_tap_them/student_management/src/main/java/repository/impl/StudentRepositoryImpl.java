package repository.impl;

import bean.StudentClass;
import bean.Student;
import repository.IStudentRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentRepositoryImpl implements IStudentRepository {


    @Override
    public List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();

        try {
            Statement statement = BaseRepository.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from student");
            Student student = null;
            while (resultSet.next()) {
                student = new Student();
                student.setId(Integer.parseInt(resultSet.getString("id")));
                student.setAverage(Double.parseDouble(resultSet.getString("average")));
                student.setAge(Integer.parseInt(resultSet.getString("age")));
                student.setGender(resultSet.getString("gender"));
                student.setName(resultSet.getString("name"));
                student.setIdClass(Integer.parseInt(resultSet.getString("id_class")));
                studentList.add(student);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return studentList;
    }

    @Override
    public  Map<String,String> save(Student student) {
        Map<String,String> messageList = new HashMap<>();
        try {
            PreparedStatement preparedStatement =
                    BaseRepository.connection.prepareStatement("insert into student (id,name,gender,age,average,id_class)" +
                            "values(?,?,?,?,?,?)");
            preparedStatement.setInt(1, student.getId());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setString(3, student.getGender());
            preparedStatement.setInt(4, student.getAge());
            preparedStatement.setDouble(5, student.getAverage());
            preparedStatement.setInt(6, student.getIdClass());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            messageList.put("message","can not create Student");
            return messageList;
        }
        return messageList;
    }

    @Override
    public void remove(int id) {
        try {
            PreparedStatement preparedStatement =
                    BaseRepository.connection.prepareStatement("delete from student where id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Student findById(int id) {
        Student student = null;
        try {
            PreparedStatement preparedStatement =
                    BaseRepository.connection.prepareStatement("select * from student where id=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                student = new Student();
                student.setId(Integer.parseInt(resultSet.getString("id")));
                student.setAverage(Double.parseDouble(resultSet.getString("average")));
                student.setAge(Integer.parseInt(resultSet.getString("age")));
                student.setGender(resultSet.getString("gender"));
                student.setName(resultSet.getString("name"));
                student.setIdClass(Integer.parseInt(resultSet.getString("id_class")));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return student;
    }

    @Override
    public Map<String, String> update(Student student) {
        Map<String, String> messageList = new HashMap<>();

        try {
            PreparedStatement preparedStatement =
                    BaseRepository.connection.prepareStatement("update student set name=?,gender=?,age=?,average=?,id_class=? where id=?");

            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getGender());
            preparedStatement.setInt(3, student.getAge());
            preparedStatement.setDouble(4, student.getAverage());
            preparedStatement.setInt(5, student.getIdClass());
            preparedStatement.setInt(6, student.getId());

            preparedStatement.executeUpdate();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
            messageList.put("message", "invalid class id");
            return messageList;
        }
        return messageList;
    }

    @Override
    public List<Student> findByName(String name) {
        List<Student> studentList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement =
                    BaseRepository.connection.prepareStatement("select * from student " +
                            "where `name`=?");
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            Student student = null;
            while (resultSet.next()) {
                student = new Student();
                student.setId(Integer.parseInt(resultSet.getString("id")));
                student.setAverage(Double.parseDouble(resultSet.getString("average")));
                student.setAge(Integer.parseInt(resultSet.getString("age")));
                student.setGender(resultSet.getString("gender"));
                student.setName(resultSet.getString("name"));
                student.setIdClass(Integer.parseInt(resultSet.getString("id_class")));
                studentList.add(student);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return studentList;
    }

    @Override
    public List<Student> sortByAverage() {
        List<Student> studentList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement =
                    BaseRepository.connection.prepareStatement("select * from student order by average desc ");

            ResultSet resultSet = preparedStatement.executeQuery();
            Student student = null;
            while (resultSet.next()) {
                student = new Student();
                student.setId(Integer.parseInt(resultSet.getString("id")));
                student.setAverage(Double.parseDouble(resultSet.getString("average")));
                student.setAge(Integer.parseInt(resultSet.getString("age")));
                student.setGender(resultSet.getString("gender"));
                student.setName(resultSet.getString("name"));
                student.setIdClass(Integer.parseInt(resultSet.getString("id_class")));
                studentList.add(student);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return studentList;
    }

    @Override
    public List<StudentClass> findAllClass() {
        List<StudentClass> studentClassList = new ArrayList<>();
        try {
            Statement statement = BaseRepository.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from class");
            StudentClass aStudentClass = null;
            while (resultSet.next()) {
                aStudentClass = new StudentClass();
                aStudentClass.setIdClass(Integer.parseInt(resultSet.getString("id_class")));
                aStudentClass.setClassName(resultSet.getString("class_name"));
                studentClassList.add(aStudentClass);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return studentClassList;
    }

}
