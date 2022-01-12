package com.codegym.case_module_four.controller;


import com.codegym.case_module_four.model.customer.Customer;
import com.codegym.case_module_four.repository.customer.ICustomerTypeRepository;
import com.codegym.case_module_four.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
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
    public String ListPage(Model model, @RequestParam(value = "page", defaultValue = "0") Integer page) {
        Page<Customer> customerList = iCustomerService.findAll(PageRequest.of(page, 2));
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
        String[] genderList = {"Male", "Female"};
        model.addAttribute("customer", new Customer());
        model.addAttribute("genderList", genderList);
        model.addAttribute("customerTypeList", iCustomerTypeRepository.findAll());
        return "customer/create";
    }

    
    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("customer") Customer customer,
                       BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        // dùng với cách implements Validator
//        new Customer().validate(customer, bindingResult);
        if (bindingResult.hasErrors()) {
            String[] genderList = {"Male", "Female"};
            model.addAttribute("genderList", genderList);
            model.addAttribute("customerTypeList", iCustomerTypeRepository.findAll());
            return "customer/create";
        }
        redirectAttributes.addFlashAttribute("message", "Create success");
        iCustomerService.save(customer);
        return "redirect:/customer";
    }

//    @GetMapping("/delete")
//    public String showDelete(@RequestParam(name = "id") Integer id, Model model) {
//        model.addAttribute("customer", iCustomerService.findById(id));
//        return "customer/delete";
//    }
//
//    @PostMapping("/delete")
//    public String delete(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes) {
//        iCustomerService.remove(customer.getId());
//        redirectAttributes.addFlashAttribute("message", "Removed product successfully!");
//        return "redirect:/customer";
//    }

    @GetMapping("/delete")
    public String showDelete(@RequestParam(name = "id") Integer id, Model model,RedirectAttributes redirectAttributes) {
        iCustomerService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Removed  successfully!");
        return "redirect:/customer";
    }

    @GetMapping("/edit_param")
    public String showEditParam(@RequestParam(name = "id") Integer id, Model model) {
        model.addAttribute("customer", iCustomerService.findById(id));
        model.addAttribute("customerTypeList", iCustomerTypeRepository.findAll());
        String[] genderList = {"Male", "Female"};
        model.addAttribute("genderList", genderList);
        return "customer/edit";
    }

    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
//        new Customer().validate(customer, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("customer", customer);
            model.addAttribute("customerTypeList", iCustomerTypeRepository.findAll());
            String[] genderList = {"Male", "Female"};
            model.addAttribute("genderList", genderList);
            return "customer/edit";
        }
        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Edit success");
        return "redirect:/customer";
    }


    @GetMapping("/search")
    public String search(@RequestParam(name = "search") String name, Model model) {
        List<Customer> customerList = iCustomerService.findByName(name);
        model.addAttribute("customerList", customerList);
        return "customer/search_list";
    }


}
