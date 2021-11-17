package repository;

import bean.customer.Customer;

import java.util.List;

public interface ICustomerRepository {

    List<Customer> findAll();
    void save(Customer customer);
    void remove(int id);
    Customer findById(int id);
    void update(Customer employee);
    List<Customer> findByName(String name);
}
