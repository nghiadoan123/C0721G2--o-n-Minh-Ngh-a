package com.codegym.controller;

import com.codegym.dao.UserDao;
import com.codegym.model.Login;
import com.codegym.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    // cách 1
//    @GetMapping("/home")
//    public ModelAndView home() {
//        ModelAndView modelAndView = new ModelAndView("home", "login", new Login());
//        return modelAndView;
//    }
//
//    @PostMapping("/login")
//    public ModelAndView login(@ModelAttribute("login") Login login){
//        User user = UserDao.checkLogin(login);
//        if(user == null){
//            ModelAndView modelAndView = new ModelAndView("error");
//            return modelAndView;
//        } else {
//            ModelAndView modelAndView = new ModelAndView("user");
//            modelAndView.addObject("user", user);
//            return modelAndView;
//        }
//    }


    // cách 2
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String showForm(ModelMap model) {
        model.addAttribute("login", new Login());
        return "home";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String submit(@ModelAttribute Login login, ModelMap model) {
        User user = UserDao.checkLogin(login);
        model.addAttribute("user", user);
        return "user";
    }
}