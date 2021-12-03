package repository;

import bean.employee.Employee;
import bean.employee.Login;

import java.util.List;

public interface ILoginRepository {

    public  boolean login(Login login);
    void remove(String userName);
    List<Login> findAll();
}
