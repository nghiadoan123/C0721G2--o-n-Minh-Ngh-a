package com.codegym.validate_form.dto;

import com.codegym.validate_form.common.IdConstrain;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class FormDTO implements Validator {


    @NotNull(message = "Id không được để trống")
    @IdConstrain
    private Integer id;


    @NotBlank(message = "Tên không được để trống")
    @Pattern(regexp = "^[a-z A-Z]{5,}$",message = "tên không dược chưa ký tự đặc biệt")
    @Size(min = 5,max = 45, message = "dộ dài từ 5-45 ký tự")
    private String firstName;



    @NotBlank(message = "Tên không được để trống")
    @Pattern(regexp = "^[a-z A-Z]{5,}$", message = "tên không dược chưa ký tự đặc biệt")
    @Size(min = 5,max = 45, message = "dộ dài từ 5-45 ký tự")
    private String lastName;


    @NotNull(message = "Tuổi không được để trống")
    @Min(value = 18, message = "tuối phải lớn hơn 18")
    @Max(value = 120, message = "tuổi phải nhỏ hơn 120")
    private Integer age;

    @NotBlank(message = "Email không được để trống")
    @Email
    private String email;

    public FormDTO() {
    }

    public FormDTO(Integer id,  String firstName, String lastName,  Integer age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }


}
