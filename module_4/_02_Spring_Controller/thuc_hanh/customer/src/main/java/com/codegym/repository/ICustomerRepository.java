package com.codegym.repository;

import com.codegym.model.Customer;

import java.util.List;

public interface ICustomerRepository {


    List<Customer> findall();
    public Customer findOne(Integer id);
    public void save(Customer customer);
    public void remove(int id);
}
