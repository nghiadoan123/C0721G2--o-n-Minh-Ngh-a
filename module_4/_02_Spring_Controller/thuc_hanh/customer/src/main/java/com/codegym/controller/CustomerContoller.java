package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CustomerContoller {

    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping("/customer")
    public String showList(Model model){
        model.addAttribute("customerList",iCustomerService.findall());
        System.out.println("jkkkkk");
        return "list";
    }

    @GetMapping(value = "detail/{id}/{name}")
    public String getStudentDetail(@PathVariable(name = "id") Integer id,
                                   @PathVariable(name = "name") String name, Model model) {
        System.out.println(name);
        Customer customer = iCustomerService.findOne(id);
        model.addAttribute("customer", customer);
        return "detail";
    }


    @GetMapping(value = "detail")
    public String getStudentDetailRequestParam(@RequestParam(name = "id") Integer id,
                                               Model model, @RequestParam(name = "name") String name) {
        System.out.println(name);
        Customer customer = iCustomerService.findOne(id);
        model.addAttribute("customer", customer);
        return "detail";
    }

    @GetMapping(value = "/create")
    public String getPageCreate() {
        return "create";
    }


    @PostMapping(value = "/create")
    public String create(@RequestParam(name = "id") Integer id, @RequestParam("name") String name,
                         @RequestParam("email") String email,
                         @RequestParam("address") String address,
                         RedirectAttributes redirectAttributes){
        Customer customer = new Customer(id,name,email,address);
        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("msg","Create student successfully!");
        return "redirect:/customer";
    }

    @GetMapping(value = "/delete/{id}")
    public String getPageEdit(@PathVariable(name = "id") Integer id, RedirectAttributes redirectAttributes) {
        iCustomerService.remove(id);
        redirectAttributes.addFlashAttribute("msg_one","delete student successfully!");
        return "redirect:/customer";
    }



}
