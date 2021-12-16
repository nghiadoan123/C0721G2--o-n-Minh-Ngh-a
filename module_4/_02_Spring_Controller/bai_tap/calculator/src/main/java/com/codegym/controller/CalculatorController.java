package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @GetMapping("")
    public String show() {
        return "index";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam(name = "numberOne") int numberOne,
                          @RequestParam(name = "numberTwo") int numberTwo,
                          @RequestParam(name = "name") String name, Model model) {
        String result = "";
        try {
            switch (name) {
                case "+":
                    result += "Addition"+(numberOne + numberTwo);
                    break;
                case "-":
                    result += "Subtraction"+(numberOne - numberTwo);
                    break;
                case "*":
                    result += "Multiplication"+(numberOne * numberTwo);
                    break;
                case "/":
                    if (numberTwo == 0){
                        result += "can not divive with zero";

                    }else {
                        result += "Division"+(numberOne / numberTwo);
                    }
                    break;
                default:
                    result = "";
                    break;
            }
        } catch (Exception exception) {
            exception.getMessage();
        }
        model.addAttribute("result", result);
        return "index";
    }
}
