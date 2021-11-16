package repository.impl;

import bean.employee.Division;
import bean.employee.EducationDegree;
import bean.employee.Employee;
import bean.employee.Position;
import repository.IEmployeeRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements IEmployeeRepository {
    @Override
    public List<Employee> findAll() {
        List<Employee> employeeList = new ArrayList<>();
        try {
            Statement statement = BaseRepository.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from employee");
            Employee employee = null;
            Division division = null;
            EducationDegree educationDegree = null;
            Position position = null;
            while (resultSet.next()){
              employee = new Employee();
              division = new Division();
              educationDegree = new EducationDegree();
              position = new Position();
              employee.setId(resultSet.getString("employee_id"));
              employee.setName(resultSet.getString("employee_name"));
              employee.setBirthDay(resultSet.getString("birthday"));
              employee.setIdCard(resultSet.getString("id_card"));
              employee.setSalary(Double.parseDouble(resultSet.getString("salary")));
              employee.setPhone(resultSet.getString("phone"));
              employee.setEmail(resultSet.getString("email"));
              employee.setAddress(resultSet.getString("address"));
              employee.setPosition(position);
              employee.setEducationDegree(educationDegree);
              employee.setDivision(division);
              employeeList.add(employee);
            }

        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public void save(Employee employee) {
        try {
            PreparedStatement preparedStatement =
                    BaseRepository.connection.prepareStatement("insert into employee(employee_id,employee_name,position_id, degree_id, division_id,birthday,id_card,salary," +
                                    " phone,email,address) " +
                                    " values(?,?,?,?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1, employee.getId());
            preparedStatement.setString(2, employee.getName());
            preparedStatement.setInt(3, employee.getPosition().getId());
            preparedStatement.setInt(4, employee.getEducationDegree().getId());
            preparedStatement.setInt(5, employee.getDivision().getId());
            preparedStatement.setString(6, employee.getBirthDay());
            preparedStatement.setString(7, employee.getIdCard());
            preparedStatement.setDouble(8, employee.getSalary());
            preparedStatement.setString(9, employee.getPhone());
            preparedStatement.setString(10, employee.getEmail());
            preparedStatement.setString(11, employee.getAddress());

            preparedStatement.executeLargeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void remove(int id) {
        try {
            PreparedStatement preparedStatement =
                    BaseRepository.connection.prepareStatement("delete from employee where employee_id = ?");
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Employee findById(String id) {
        List< Employee > listEmployee = findAll();
        Employee employee = null;
        for (Employee list : listEmployee) {
            if (list.getId().contains(id)) {
                employee = list;
            }
        }
        return employee;
    }

    @Override
    public void update(Employee employee) {
        try {
            PreparedStatement preparedStatement =
                    BaseRepository.connection.prepareStatement("update employee set employee_id=?, employee_name=?,position_id=?," +
                            "degree_id=?,division_id=?,birthday=?,id_card=?,salary=?,phone=?,email=?,address=? where id=?");

            preparedStatement.setString(1, employee.getId());
            preparedStatement.setString(2, employee.getName());
            preparedStatement.setInt(3, employee.getPosition().getId());
            preparedStatement.setInt(4, employee.getEducationDegree().getId());
            preparedStatement.setInt(5, employee.getDivision().getId());
            preparedStatement.setString(6, employee.getBirthDay());
            preparedStatement.setString(7, employee.getIdCard());
            preparedStatement.setDouble(8, employee.getSalary());
            preparedStatement.setString(9, employee.getPhone());
            preparedStatement.setString(10, employee.getEmail());
            preparedStatement.setString(11, employee.getAddress());

            preparedStatement.executeLargeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Employee> findByName(String name) {
        return null;
    }

}
