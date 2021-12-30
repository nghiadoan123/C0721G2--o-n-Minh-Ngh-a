package com.codegym.borrow_book.controller;

import com.codegym.borrow_book.model.Book;
import com.codegym.borrow_book.model.CardBorrow;
import com.codegym.borrow_book.service.IBookService;
import com.codegym.borrow_book.service.ICardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    IBookService iBookService;

    @Autowired
    ICardService iCardService;


    @GetMapping({"", "/list"})
    public String showList(Model model) {
        List<Book> bookList = iBookService.getAll();
        model.addAttribute("bookList", bookList);
        return "book/index";
    }

    @GetMapping("{id}/view")
    public String view(@PathVariable("id") Integer id, Model model) throws Exception {
        Book book = iBookService.findById(id);
        if (book == null) {
            throw new Exception();
        }
        model.addAttribute("book", book);
        return "book/view";
    }


    @GetMapping("{id}/delete")
    public String showDelete(@PathVariable(name = "id") int id, Model model) {
        model.addAttribute("book", iBookService.findById(id));
        return "book/delete";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute("book") Book book, RedirectAttributes redirectAttributes) {
        iBookService.remove(book.getId());
        redirectAttributes.addFlashAttribute("message", "Removed product successfully!");
        return "redirect:/book/list";
    }

    @GetMapping("/search")
    public String search(@RequestParam(name = "name") String name, Model model) throws Exception {
        List<Book> bookList = iBookService.findByName(name);
        if (bookList == null) {
            throw new Exception();
        }
        model.addAttribute("bookList", bookList);
        return "book/search_list";
    }

    @GetMapping("/borrow")
    public String borrow(@RequestParam(name = "id") Integer id, Model model) throws Exception {
        Book book = iBookService.findByIdDecrease(id);


        if (book.getNumber() < 0) {
            throw new Exception();
        }
        iBookService.save(book);

        List<Book> bookList = iBookService.getAll();

        if (bookList == null || book.getNumber() < 0) {
            throw new Exception();
        }


        CardBorrow cardBorrow = new CardBorrow();

        int ramDom = (int) (Math.random() * 100);
        cardBorrow.setCodeBorrow(ramDom);
        cardBorrow.setId(book.getId());
        cardBorrow.setBook(book);
        iCardService.save(cardBorrow);


        model.addAttribute("bookList", bookList);
        model.addAttribute("cardborrow", cardBorrow.getCodeBorrow());
        return "book/index";
    }

    @GetMapping("/return")
    public String returnBook(@RequestParam(name = "id") Integer id, Model model) {
        Book book = iBookService.findById(id);
        model.addAttribute("book", book);
        return "book/give_book_back";
    }


    @PostMapping("/return")
    public String returnConfirm(@ModelAttribute(name = "book") Book book,
                                @RequestParam(name = "id") Integer id,
                                @RequestParam(name = "codeBorrow") Integer codeBorrow,
                                Model model) {
        Book book1 = null;
        for (CardBorrow cardBorrow : iCardService.getAll()) {
            if (cardBorrow.getCodeBorrow() == codeBorrow) {
                book1 = iBookService.findByIdIncrease(id);
                iBookService.save(book1);
                break;
            }
        }
        List<Book> bookList = new ArrayList<>();
        bookList.add(book1);
        model.addAttribute("bookList",bookList);
        return "book/index";
    }


    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("cardBorrowList", iCardService.getAll());
        return "book/create";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) throws Exception {

        if (bindingResult.hasErrors()) {
            model.addAttribute("cardBorrowList", iCardService.getAll());
            return "/book/create";

        }
        if (book == null) {
            throw new Exception();
        }
        redirectAttributes.addFlashAttribute("message", "Create success");
        iBookService.save(book);
        return "redirect:/book/list";
    }


    @ExceptionHandler(Exception.class)
    public String handleException() {
        return "/book/exception";
    }


}
