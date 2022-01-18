package com.codegym.management.controller;


import com.codegym.management.model.Product;
import com.codegym.management.service.IContractService;
import com.codegym.management.service.IProductService;
import com.codegym.management.service.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    IProductService iProductService;

    @Autowired
    IContractService iContractService;

    @Autowired
    IProductTypeService iProductTypeService;


    @GetMapping
    public String ListPage(Model model, @RequestParam(value = "page", defaultValue = "0") Integer page) {


//        Sort sort = Sort.by("title").ascending().and(Sort.by("dateCreate").descending());
        Page<Product> productList = iProductService.findAll(PageRequest.of(page, 2));
        model.addAttribute("productList", productList);


        return "product/list";
    }



    @GetMapping("{id}/view")
    public String view(@PathVariable("id") Integer id, Model model) {
        Product product = iProductService.findById(id);
        model.addAttribute("product", product);
        return "product/view";
    }



    @GetMapping("/edit_param")
    public String showEditParam(@RequestParam(name = "id") Integer id, Model model, Principal principal) {

        model.addAttribute("product", iProductService.findById(id));
        model.addAttribute("productTypeList", iProductTypeService.getAll());
        String[] statusList = {"Ok", "Ng"};
        model.addAttribute("statusList", statusList);
        return "product/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("product") Product product, Model model, RedirectAttributes redirectAttributes) throws Exception {


        iProductService.save(product);
        redirectAttributes.addFlashAttribute("message", "Edit success");
        return "redirect:/product";
    }


}
