package com.codegym.controller;

import com.codegym.model.Information;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FormController {

    @GetMapping("")
    public String getFormPage(Model model){
        String[] countries = new String[]{"VN","USA","JP","CN"};
        String[] gender = new String[]{"male","female"};
        String[] transferBy= new String[]{"Tau bay","Tau thuyen", "O to", "Khac"};
        String[] cityName = new String[]{"DN","TP.HCM","HN"};
        String [] district = new String[] {"Hai Chau", "Thanh Khe", "Lien Chieu"};
        String [] ward = new String[]{"Thanh Binh", "Thac Gian"};

        model.addAttribute("gender",gender);
        model.addAttribute("countries",countries);
        model.addAttribute("transferBy",transferBy);
        model.addAttribute("province",cityName);
        model.addAttribute("district",district);
        model.addAttribute("ward",ward);

        model.addAttribute("information",new Information());

        return "index";
    }

    @GetMapping("/error")
    public String errorList(){
        return "error";
    }

    @PostMapping("/send_declaration")
    public String createForm(@ModelAttribute("information") Information information, Model model,
                             RedirectAttributes redirectAttributes){
        String nameErr = "Chua nhap ten";
        String name = information.getName();

        model.addAttribute("information",information);
        if (nameErr != name){
            model.addAttribute("nameErr",nameErr);
            return "error";
        }else {
            return "index";
        }

    }
}
