package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwitchController {

    @GetMapping("")
    public String showCheckBox(){
        return "index";
    }

    @PostMapping("/sand_witch")
    public String showResult(@RequestParam(name = "condiment") String[] condiment, Model model){
        model.addAttribute("condimentList",condiment);
        return "result";
    }
}
