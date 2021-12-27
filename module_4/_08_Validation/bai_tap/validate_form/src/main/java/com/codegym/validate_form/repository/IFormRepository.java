package com.codegym.validate_form.repository;

import com.codegym.validate_form.model.Form;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository(value = "iFormRepository")
public interface IFormRepository extends JpaRepository<Form,Integer> {

}
