package com.codegym.validate_form.service;

import com.codegym.validate_form.dto.FormDTO;
import com.codegym.validate_form.model.Form;

public interface IFormService {

    void save(FormDTO formDTO);
}
