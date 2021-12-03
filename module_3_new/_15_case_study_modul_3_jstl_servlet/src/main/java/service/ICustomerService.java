package service;

import bean.customer.Customer;

import java.util.List;

public interface ICustomerService {

    List<Customer> findAll();
    void save(Customer customer);
    void remove(int id);
    Customer findById(int id);
    void update(Customer customer);
    List<Customer> findByName(String name);

}
