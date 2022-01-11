package com.codegym.case_module_four.controller;


import com.codegym.case_module_four.model.customer.Customer;
import com.codegym.case_module_four.model.employee.Employee;
import com.codegym.case_module_four.repository.customer.ICustomerTypeRepository;
import com.codegym.case_module_four.service.customer.ICustomerService;
import com.codegym.case_module_four.service.employee.IDivisionService;
import com.codegym.case_module_four.service.employee.IEducationDegreeService;
import com.codegym.case_module_four.service.employee.IEmployeeService;
import com.codegym.case_module_four.service.employee.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    IEmployeeService iEmployeeService;

    @Autowired
    IDivisionService iDivisionService;

    @Autowired
    IPositionService iPositionService;

    @Autowired
    IEducationDegreeService iEducationDegreeService;

    @GetMapping
    public String List(Model model){
        List<Employee> employeeList = iEmployeeService.getAll();
        model.addAttribute("employeeList", employeeList);
        return "employee/list";
    }


    @GetMapping("{id}/view")
    public String view(@PathVariable("id") Integer id, Model model) {
        Employee employee = iEmployeeService.findById(id);
        model.addAttribute("employee", employee);
        return "employee/view";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("divisionList",iDivisionService.getAll());
        model.addAttribute("educationDegreeList",iEducationDegreeService.getAll());
        model.addAttribute("positionList",iPositionService.getAll());
        return "employee/create";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("employee") Employee employee,
                       BindingResult bindingResult,Model model, RedirectAttributes redirectAttributes) {
        new Employee().validate(employee,bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("divisionList",iDivisionService.getAll());
            model.addAttribute("educationDegreeList",iEducationDegreeService.getAll());
            model.addAttribute("positionList",iPositionService.getAll());
            return "employee/create";
        }
        redirectAttributes.addFlashAttribute("message", "Create success");
        iEmployeeService.save(employee);
        return "redirect:/employee";
    }

    @GetMapping("{id}/delete")
    public String showDelete(@PathVariable(name = "id") Integer id, Model model) {
        model.addAttribute("employee", iEmployeeService.findById(id));
        return "employee/delete";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute("employee") Employee employee, RedirectAttributes redirectAttributes) {
        iEmployeeService.remove(employee.getId());
        redirectAttributes.addFlashAttribute("message", "Removed  successfully!");
        return "redirect:/employee";
    }

    @GetMapping("/edit_param")
    public String showEditParam(@RequestParam(name = "id") Integer id, Model model) {
        model.addAttribute("employee", iEmployeeService.findById(id));
        model.addAttribute("divisionList",iDivisionService.getAll());
        model.addAttribute("educationDegreeList",iEducationDegreeService.getAll());
        model.addAttribute("positionList",iPositionService.getAll());

        return "employee/edit";
    }

    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute("employee") Employee employee,BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        new Employee().validate(employee,bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("divisionList",iDivisionService.getAll());
            model.addAttribute("educationDegreeList",iEducationDegreeService.getAll());
            model.addAttribute("positionList",iPositionService.getAll());
            return "employee/edit";
        }
        iEmployeeService.save(employee);
        redirectAttributes.addFlashAttribute("message", "Edit success");
        return "redirect:/employee";
    }
}
