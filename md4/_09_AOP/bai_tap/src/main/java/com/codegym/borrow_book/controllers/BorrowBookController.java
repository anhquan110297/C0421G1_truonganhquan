package com.codegym.borrow_book.controllers;

import com.codegym.borrow_book.Exception.NotFoundCode;
import com.codegym.borrow_book.models.entity.Book;
import com.codegym.borrow_book.models.entity.BorrowCode;
import com.codegym.borrow_book.models.services.IBorrowBookServices;
import com.codegym.borrow_book.models.services.RandomCodeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BorrowBookController {
    @Autowired
    private IBorrowBookServices borrowBookServices;
    @Autowired
    private RandomCodeServiceInterface randomCodeService;

    @GetMapping(value = {"", "/home"})
    public String viewList(Model model) {
        List < Book > bookList = this.borrowBookServices.findAll();
        model.addAttribute("bookList", bookList);
        return "view";
    }

    @GetMapping(value = "/detail/{id}")
    public String viewDetail(@PathVariable int id, Model model) {
        model.addAttribute("book", this.borrowBookServices.findById(id));
        return "detail";
    }

    @PostMapping(value = "/detail")
    public String actionBorrow (Model model, @ModelAttribute Book book, RedirectAttributes redirectAttributes){
        int borrowCode = (int) ((Math.random()*89999) +10000);
        book.setAmount(book.getAmount()-1);
        this.borrowBookServices.save(book);
        this.randomCodeService.save(new BorrowCode(borrowCode,book));
        redirectAttributes.addFlashAttribute("borrowCode",borrowCode);
        return "redirect:/home";
    }

    @GetMapping(value = "/pay/{id}")
    public String viewPay (@PathVariable int id , Model model){
        return "pay";
    }

    @PostMapping (value = "/pay")
    public String actionPay (Model model, @RequestParam(value = "input") long code,RedirectAttributes redirectAttributes) throws Exception {
        BorrowCode borrowCode = this.randomCodeService.findById(code);
        if (borrowCode == null){
            throw new NotFoundCode("Exception Message");
        }
        Book book = borrowCode.getBook();
        book.setAmount(book.getAmount()+1);
        this.borrowBookServices.save(book);
        this.randomCodeService.remove(code);
        model.addAttribute("msg","Give back success!");
        return "redirect:/home";
    }

//    @ExceptionHandler(NotFoundCode.class)
//    public String showError() {
//        return "hihi";
//    }
}
