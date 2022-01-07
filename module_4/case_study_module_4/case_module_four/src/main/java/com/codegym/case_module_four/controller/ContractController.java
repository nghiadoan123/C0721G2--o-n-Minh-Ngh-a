package com.codegym.case_module_four.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contract")
public class ContractController {

    @GetMapping
    public String List(){
        return "contract/list";
    }
}
