package com.codegym.validate_form.service.impl;

import com.codegym.validate_form.dto.FormDTO;
import com.codegym.validate_form.model.Form;
import com.codegym.validate_form.repository.IFormRepository;
import com.codegym.validate_form.service.IFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;


@Service(value = "iFormService")
public class FormServiceImpl implements IFormService {
    @Autowired
    @Qualifier(value = "iFormRepository")
    IFormRepository iFormRepository;


    @Override
    public void save(FormDTO formDTO) {
        Form form = new Form(formDTO.getId(),formDTO.getFirstName(),formDTO.getLastName(),formDTO.getAge(),formDTO.getEmail());
        iFormRepository.save(form);
    }
}
