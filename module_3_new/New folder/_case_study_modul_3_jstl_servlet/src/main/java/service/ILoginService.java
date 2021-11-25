package service;

import bean.employee.Login;

import java.util.List;

public interface ILoginService {

    public  boolean login(Login login);
    void remove(String userName);
    List<Login> findAll();
}
