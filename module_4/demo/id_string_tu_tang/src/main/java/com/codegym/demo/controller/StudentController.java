package com.codegym.demo.controller;


import com.codegym.demo.model.Student;
import com.codegym.demo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    IStudentService iStudentService;


    @GetMapping({"", "/list"})
    public String showList(Model model) {
        List<Student> studentList = iStudentService.getAll();
        model.addAttribute("studentList", studentList);
        return "student/index";
    }


    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("student", new Student());
        return "student/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("student") Student student, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", "Create success");
        iStudentService.save(student);
        return "redirect:/student/list";
    }


}
