package com.codegym.management.service;

import com.codegym.management.model.Contract;
import com.codegym.management.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {

    List<Contract> getAll();

    Contract findById(Integer id);

    void save(Contract contract);

    List<Contract> findByName(String name);

    void remove(Integer id);

    Page<Contract> findAll(Pageable pageable);
}
