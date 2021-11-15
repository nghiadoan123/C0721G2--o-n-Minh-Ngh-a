package service.impl;

import bean.employee.Employee;
import repository.IEmployeeRepository;
import repository.impl.EmployeeRepositoryImpl;
import service.IEmployeeService;

import java.util.List;

public class EmployServiceImpl  implements IEmployeeService {
    IEmployeeRepository iEmployeeRepository = new EmployeeRepositoryImpl();
    @Override
    public List<Employee> findAll() {
        return iEmployeeRepository.findAll();
    }

    @Override
    public void save(Employee employee) {
        iEmployeeRepository.save(employee);
    }

    @Override
    public void remove(int id) {
        iEmployeeRepository.remove(id);
    }

    @Override
    public Employee findById(int id) {
        return iEmployeeRepository.findById(id);
    }

    @Override
    public void update(Employee employee) {
        iEmployeeRepository.update(employee);
    }

    @Override
    public List<Employee> findByName(String name) {
        return iEmployeeRepository.findByName(name);
    }
    
}
