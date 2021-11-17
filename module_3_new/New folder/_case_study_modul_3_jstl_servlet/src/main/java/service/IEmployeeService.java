package service;

import bean.employee.Employee;

import java.util.List;

public interface IEmployeeService {

    List<Employee> findAll();
    void save(Employee employee);
    void remove(int id);
    Employee findById(String id);
    void update(Employee employee);
    List<Employee> findByName(String name);

}
