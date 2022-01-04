package com.codegym.phone_management.repository;

import com.codegym.phone_management.model.Smartphone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISmartphoneRepository extends CrudRepository<Smartphone, Long> {
}
