package com.codegym.shopping_cart.controller;

import com.codegym.shopping_cart.model.Cart;
import com.codegym.shopping_cart.model.Product;
import com.codegym.shopping_cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class ShoppingCartController {

    @Autowired
    IProductService iProductService;

    @ModelAttribute("cart")
    public Cart setupCart(){
        return new Cart();
    }

    @GetMapping("/shopping-cart")
    public ModelAndView showCart (@SessionAttribute("cart") Cart cart){
        ModelAndView modelAndView = new ModelAndView("/cart");
        modelAndView.addObject("cart",cart);
        return modelAndView;
    }

    @GetMapping("/view")
    public String view(@RequestParam("id") long id, Model model){
       Optional<Product> product = iProductService.findById(id);
        model.addAttribute("product",product);
        return "view";
    }

    @GetMapping("/pay")
    public String payment(@SessionAttribute("cart") Cart cart, Model model){
        model.addAttribute("cart",cart);
        return "pay";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id, @SessionAttribute("cart") Cart cart, RedirectAttributes redirectAttributes) {
        Product productOptional = iProductService.findId(id);
        cart.deleteProduct(productOptional);
        redirectAttributes.addFlashAttribute("message", "Removed product successfully!");
        return "redirect:/shopping-cart";
    }
}