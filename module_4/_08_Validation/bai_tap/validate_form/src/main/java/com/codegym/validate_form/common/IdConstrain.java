package com.codegym.validate_form.common;

import com.codegym.validate_form.common.validator.IdValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = IdValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IdConstrain {

    String message() default "Invalid id";
    Class<?>[] groups() default {};
    Class<?extends Payload> [] payload() default {};
}
