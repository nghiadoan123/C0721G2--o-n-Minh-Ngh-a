package com.codegym.validate_form.common.validator;

import com.codegym.validate_form.common.IdConstrain;
import com.codegym.validate_form.repository.IFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IdValidator implements ConstraintValidator<IdConstrain,Integer> {
    @Autowired
    @Qualifier(value = "iFormRepository")
    private IFormRepository iFormRepository;


    @Override
    public void initialize(IdConstrain constraintAnnotation) {

    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (iFormRepository.getById(value).getId()<0 ){
            return false ;
        }
        return true;
    }
}
