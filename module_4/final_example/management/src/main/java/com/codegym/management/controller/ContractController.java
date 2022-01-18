package com.codegym.management.controller;


import com.codegym.management.model.Contract;
import com.codegym.management.model.Product;
import com.codegym.management.service.IContractService;
import com.codegym.management.service.IProductService;
import com.codegym.management.service.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/contract")
public class ContractController {


    @Autowired
    IProductService iProductService;

    @Autowired
    IContractService iContractService;

    @Autowired
    IProductTypeService iProductTypeService;


    @GetMapping
    public String ListPage(Model model, @RequestParam(value = "page", defaultValue = "0") Integer page) {


//        Sort sort = Sort.by("title").ascending().and(Sort.by("dateCreate").descending());
        Page<Contract> contractList = iContractService.findAll(PageRequest.of(page, 2));
        model.addAttribute("contractList", contractList);


        return "contract/list";
    }


    @GetMapping("/edit_param")
    public String showEditParam(@RequestParam(name = "id") Integer id, Model model, Principal principal) {

        model.addAttribute("contract", iContractService.findById(id));
        model.addAttribute("productList", iProductService.getAll());
//        String[] statusList = {"Ok", "Ng"};
//        model.addAttribute("statusList", statusList);
        return "contract/edit";
    }

    @PostMapping("/edit")
    public String edit(@Valid  @ModelAttribute("contract") Contract contract, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) throws Exception {

        new Contract().validate(contract, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("contract",contract);
            model.addAttribute("productList", iProductService.getAll());
            return "contract/edit";
        }

        iContractService.save(contract);
        redirectAttributes.addFlashAttribute("message", "Edit success");
        return "redirect:/contract";
    }
}


