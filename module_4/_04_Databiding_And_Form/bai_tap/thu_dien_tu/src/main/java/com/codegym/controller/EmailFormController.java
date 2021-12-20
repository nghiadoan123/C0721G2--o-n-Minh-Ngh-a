package com.codegym.controller;


import com.codegym.model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmailFormController {

    @GetMapping("")
    public String showForm(Model model){
        String[] language = new String[] {"English","Vietnamese","Japanese","chinese"};
        String[] pageSize = new String[] {"5","10","15","20","25","100"};
//        String[] spamsFilter = new String[] {"Yes","No"};
        model.addAttribute("language", language);
        model.addAttribute("pageSize",pageSize);
//        model.addAttribute("spamsFilter",spamsFilter);
        model.addAttribute("Email",new Email());
        return "email/form";
    }


    @PostMapping("/show")
    public String create(@ModelAttribute ("Email") Email email, Model model){
        model.addAttribute("email", email);
        return "email/show";
    }

}
