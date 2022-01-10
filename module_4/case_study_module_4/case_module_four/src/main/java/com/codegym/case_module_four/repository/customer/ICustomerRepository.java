package com.codegym.case_module_four.repository.customer;


import com.codegym.case_module_four.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Integer> {


    List<Customer> findByName(String name);
}
