package com.codegym.controller;


import com.codegym.model.Product;
import com.codegym.service.IProductService;
import com.codegym.service.impl.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/product")
public class ProductController {
    IProductService iProductService = new ProductService();


    @GetMapping("")
    public String showList(Model model){
        List<Product> productList = iProductService.findAll();
        model.addAttribute("productList",productList);
        return "index";
    }

    @GetMapping("/{id}/delete")
    public  String showDelete(@PathVariable(name = "id") int id, Model model){
        // @PathVariable(name = "id" lấy ì tư thanh url product/{id}/delete bỏ vào biến int id
        model.addAttribute("product",iProductService.findById(id));
        return "delete";
    }

    @PostMapping("/delete")
    public  String delete(@ModelAttribute("product") Product product, RedirectAttributes redirectAttributes){
        iProductService.remove(product.getId());
        redirectAttributes.addFlashAttribute("message","Removed product successfully!");
        return "redirect:/product";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        // tạo thành đối tượng product1 trong file html create dòng 19
        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("product") Product product, RedirectAttributes redirectAttributes) {
        product.setId((int) (Math.random() * 10000));
        redirectAttributes.addFlashAttribute("message","Create success");
        iProductService.save(product);

        return "redirect:/product";
    }


    @GetMapping("{id}/edit")
    public String showEdit(@PathVariable(name = "id") int id, Model model){
        model.addAttribute("product",iProductService.findById(id));
        return "edit";
    }

    @GetMapping("/edit_param")
    public String showEditParam(@RequestParam(name = "id") int id, Model model){
        model.addAttribute("product",iProductService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(Product product, Model model,RedirectAttributes redirectAttributes){
        iProductService.update(product.getId(),product);
        redirectAttributes.addFlashAttribute("message","Edit success");
        return "redirect:/product";
    }

    @GetMapping("{id}/view")
    public String view(@PathVariable(name = "id") int id,Model model){
        Product product = iProductService.findById(id);
        model.addAttribute("product",product);
        return "view";
    }

    @GetMapping("/search")
    public String search(@RequestParam(name = "search") String search, Model model){
        List<Product> productList = iProductService.searchName(search);
        model.addAttribute("productList",productList);
        return "index";
    }
}

