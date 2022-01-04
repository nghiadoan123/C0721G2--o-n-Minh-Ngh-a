package com.codegym.validate_form.controller;


import com.codegym.validate_form.dto.FormDTO;
import com.codegym.validate_form.model.Form;
import com.codegym.validate_form.service.IFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
@RequestMapping(value = "/form")
public class FormController {

    @Autowired
    @Qualifier(value = "iFormService")
    IFormService iFormService;


    @GetMapping(name = "")
    String showCreateForm(Model model) {
        model.addAttribute("form", new FormDTO());
        return "create";
    }

    @PostMapping("/create")
    String create(@Valid @ModelAttribute(name = "form") FormDTO formDTO, BindingResult bindingResult) {

        // dùng với cách implements Validator
        new FormDTO().validate(formDTO,bindingResult);

        if (bindingResult.hasErrors()) {
            return "create";
        }else {
            return "result";
        }
    }
}
