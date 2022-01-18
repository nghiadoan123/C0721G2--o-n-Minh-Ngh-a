package com.codegym.management.controller;


import com.codegym.management.model.Book;
import com.codegym.management.service.IBookService;
import com.codegym.management.service.IBookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    IBookService iBookService;

    @Autowired
    IBookTypeService iBookTypeService;

    @GetMapping
    public String ListPage(Model model, @RequestParam(value = "page", defaultValue = "0") Integer page) {


        Sort sort = Sort.by("title").ascending().and(Sort.by("dateCreate").descending());
        Page<Book> questionList = iBookService.findAll(PageRequest.of(page, 2,sort));
        model.addAttribute("bookList", questionList);


        return "question/list";
    }



    @GetMapping("{id}/view")
    public String view(@PathVariable("id") Integer id, Model model) {
        Book book = iBookService.findById(id);
        model.addAttribute("book", book);
        return "question/view";
    }



    @GetMapping("/delete")
    public String showDelete(@RequestParam(name = "id") Integer id, Model model, RedirectAttributes redirectAttributes) {
        iBookService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Removed  successfully!");
        return "redirect:/question";
    }

    @GetMapping("/edit_param")
    public String showEditParam(@RequestParam(name = "id") Integer id, Model model,Principal principal) {

        model.addAttribute("question", iBookService.findById(id));
        model.addAttribute("questionTypeList", iBookTypeService.getAll());
        String[] statusList = {"Chờ Phản Hồi", "Đã Phản Hồi"};
        model.addAttribute("statusList", statusList);
        return "question/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("question") Book book, Model model, RedirectAttributes redirectAttributes) throws Exception {


//        new Customer().validate(customer, bindingResult);
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("customer", customer);
//            model.addAttribute("customerTypeList", iCustomerTypeRepository.findAll());
//            String[] genderList = {"Male", "Female"};
//            model.addAttribute("genderList", genderList);
//            return "customer/edit";
//        }
//        if (customer == null){
//            throw new Exception();
//        }
        iBookService.save(book);
        redirectAttributes.addFlashAttribute("message", "Edit success");
        return "redirect:/question";
    }


    @GetMapping("/create")
    public String create(Model model) {
        String[] statusList = {"Chờ phản hồi", "Đã phản hồi"};
        model.addAttribute("question", new Book());
        model.addAttribute("statusList", statusList);
        model.addAttribute("questionTypeList", iBookTypeService.getAll());


        return "question/create";
    }


    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("question") Book book,
                       BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes,Principal principal) {



        // dùng với cách implements Validator
//        new Customer().validate(customer, bindingResult);

//
//        if (bindingResult.hasErrors()) {
//            String[] genderList = {"Male", "Female"};
//            model.addAttribute("genderList", genderList);
//            model.addAttribute("customerTypeList", iCustomerTypeRepository.findAll());
//            return "customer/create";
//        }
        redirectAttributes.addFlashAttribute("message", "Create success");
        iBookService.save(book);
        return "redirect:/question";
    }



    @GetMapping("/search")
    public String search(@RequestParam(name = "title", required = false) String title,
                         @RequestParam(value = "page", defaultValue = "0") Integer page,
                         Model model,Principal principal) {


            model.addAttribute("questionList", iBookService.findByName(title));
            return "question/search_list";

    }
}
