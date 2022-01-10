package com.codegym.case_module_four.controller;


import com.codegym.case_module_four.model.customer.Customer;
import com.codegym.case_module_four.model.service.Services;
import com.codegym.case_module_four.repository.customer.ICustomerTypeRepository;
import com.codegym.case_module_four.service.customer.ICustomerService;
import com.codegym.case_module_four.service.service.IRentalTypeService;
import com.codegym.case_module_four.service.service.IServiceService;
import com.codegym.case_module_four.service.service.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/service")
public class ServiceController {

    @Autowired
    IServiceService iServiceService;

    @Autowired
    IRentalTypeService iRentalTypeService;

    @Autowired
    IServiceTypeService iServiceTypeService;


    @GetMapping
    public String List(Model model){
        List<Services> serviceList = iServiceService.getAll();
        model.addAttribute("serviceList", serviceList);
        return "service/list";
    }


    @GetMapping("{id}/view")
    public String view(@PathVariable("id") Integer id, Model model) {
        Services service = iServiceService.findById(id);
        model.addAttribute("service", service);
        return "service/view";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("service", new Services());
        model.addAttribute("rentalTypeList",iRentalTypeService.getAll());
        model.addAttribute("serviceTypeList",iServiceTypeService.getAll());
        return "service/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("service") Services service, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", "Create success");
        iServiceService.save(service);
        return "redirect:/service";
    }

    @GetMapping("{id}/delete")
    public String showDelete(@PathVariable(name = "id") Integer id, Model model) {
        model.addAttribute("service", iServiceService.findById(id));
        return "service/delete";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute("service") Services service, RedirectAttributes redirectAttributes) {
        iServiceService.remove(service.getId());
        redirectAttributes.addFlashAttribute("message", "Removed product successfully!");
        return "redirect:/service";
    }

    @GetMapping("/edit_param")
    public String showEditParam(@RequestParam(name = "id") Integer id, Model model) {
        model.addAttribute("service", iServiceService.findById(id));
        model.addAttribute("serviceTypeList",iServiceTypeService.getAll());
        model.addAttribute("rentalTypeList",iRentalTypeService.getAll());
        return "service/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("service") Services service, Model model, RedirectAttributes redirectAttributes) {
        iServiceService.save(service);
        redirectAttributes.addFlashAttribute("message", "Edit success");
        return "redirect:/service";
    }

}
