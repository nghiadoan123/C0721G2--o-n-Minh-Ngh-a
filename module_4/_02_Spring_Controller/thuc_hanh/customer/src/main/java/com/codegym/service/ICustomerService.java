package com.codegym.service;

import com.codegym.model.Customer;

import java.util.List;

public interface ICustomerService {

    List<Customer> findall();
    public Customer findOne(Integer id);
    public void save(Customer customer);
    public void remove(int id);
}
