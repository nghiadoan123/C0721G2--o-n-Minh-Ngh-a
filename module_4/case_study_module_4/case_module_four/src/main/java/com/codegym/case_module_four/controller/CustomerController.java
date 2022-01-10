package com.codegym.case_module_four.controller;


import com.codegym.case_module_four.model.customer.Customer;
import com.codegym.case_module_four.repository.customer.ICustomerTypeRepository;
import com.codegym.case_module_four.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    ICustomerService iCustomerService;

    @Autowired
    ICustomerTypeRepository iCustomerTypeRepository;

//    @GetMapping
//    public String List(Model model){
//        List<Customer> customerList = iCustomerService.getAll();
//        model.addAttribute("customerList", customerList);
//        return "customer/list";
//    }


    @GetMapping
    public String ListPage(Model model,@RequestParam(value = "page",defaultValue = "0") Integer page){
        Page<Customer> customerList = iCustomerService.findAll(PageRequest.of(page,2));
        model.addAttribute("customerList", customerList);
        return "customer/list";
    }



    @GetMapping("{id}/view")
    public String view(@PathVariable("id") Integer id, Model model) {
        Customer customer = iCustomerService.findById(id);
        model.addAttribute("customer", customer);
        return "customer/view";
    }

    @GetMapping("/create")
    public String create(Model model) {
        String [] genderList = {"Male","Female"};
        model.addAttribute("customer", new Customer());
        model.addAttribute("genderList", genderList);
        model.addAttribute("customerTypeList",iCustomerTypeRepository.findAll());
        return "customer/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", "Create success");
        iCustomerService.save(customer);
        return "redirect:/customer";
    }

    @GetMapping("{id}/delete")
    public String showDelete(@PathVariable(name = "id") Integer id, Model model) {
        model.addAttribute("customer", iCustomerService.findById(id));
        return "customer/delete";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes) {
        iCustomerService.remove(customer.getId());
        redirectAttributes.addFlashAttribute("message", "Removed product successfully!");
        return "redirect:/customer";
    }

    @GetMapping("/edit_param")
    public String showEditParam(@RequestParam(name = "id") Integer id, Model model) {
        model.addAttribute("customer", iCustomerService.findById(id));
        model.addAttribute("customerTypeList",iCustomerTypeRepository.findAll());
        String [] genderList = {"Male","Female"};
        model.addAttribute("genderList",genderList);
        return "customer/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("customer") Customer customer, Model model, RedirectAttributes redirectAttributes) {
        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Edit success");
        return "redirect:/customer";
    }



}
