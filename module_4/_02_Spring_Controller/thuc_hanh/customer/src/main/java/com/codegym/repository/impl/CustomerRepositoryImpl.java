package com.codegym.repository.impl;

import com.codegym.model.Customer;
import com.codegym.repository.ICustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CustomerRepositoryImpl implements ICustomerRepository {

    private static List<Customer> customers = new ArrayList<>();


    static {
        customers.add(new Customer(1, "T", "t@codegym.vn", "Da Nang"));
        customers.add(new Customer(2, "Nhat", "nhat@codegym.vn", "Quang Tri"));
        customers.add(new Customer(3, "Trang", "trang@codegym.vn", "Ha Noi"));
        customers.add(new Customer(4, "Nguyen Binh Son", "son@codegym.vn", "Sai Gon"));
        customers.add(new Customer(5, "Dang Xuan Hoa", "hoa.dang@codegym.vn", "Da Nang"));
    }


    @Override
    public List<Customer> findall() {
        return customers;
    }

    @Override
    public Customer findOne(Integer id) {
        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public void save(Customer customer) {
        customers.add(customer);
    }

    @Override
    public void remove(int id) {
        customers.remove(id);
    }

}
