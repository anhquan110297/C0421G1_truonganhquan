package com.codegym.blog.controllers;

import com.codegym.blog.models.entities.Blog;
import com.codegym.blog.models.service.BlogServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/home")
public class BlogController {
    @Autowired
    BlogServiceInterface blogService;

    @GetMapping(value = "/view")
    public String show(Model model) {
        List<Blog> blogList = blogService.showList();
        model.addAttribute("blogList", blogList);
        return "view";
    }
    @GetMapping (value = "/create")
    public String showCreate (Model model){
        model.addAttribute("blog",new Blog());
        return "create";
    }

    @PostMapping (value = "/create")
    public String create (@ModelAttribute Blog newBlog, Model model, RedirectAttributes redirectAttributes){
        this.blogService.save(newBlog);
        redirectAttributes.addFlashAttribute("msg","Create new blog success!!");
        return "redirect:/home/view";
    }
    @GetMapping (value = "/update/{id}")
    public String showUpdate (@PathVariable int id, Model model){
        model.addAttribute("blog",this.blogService.findById(id));
        return "edit";
    }

    @PostMapping (value = "/update")
    public String update (@ModelAttribute Blog newBlog,Model model, RedirectAttributes redirectAttributes){
        this.blogService.save(newBlog);
        redirectAttributes.addFlashAttribute("msg","update success!!");
        return "redirect:/home/view";
    }

    @GetMapping (value = "/delete/{id}")
    public String showDelete (@PathVariable int id, Model model){
        model.addAttribute("blog",this.blogService.findById(id));
        return "delete";
    }
    @PostMapping (value = "/delete")
    public String delete (@ModelAttribute Blog blog,Model model,RedirectAttributes redirectAttributes){
        this.blogService.delete(blog);
        redirectAttributes.addFlashAttribute("msg","delete success!!");
        return "redirect:/home/view";
    }

    @GetMapping (value = "detail/{id}")
    public String viewDetail (@PathVariable int id,Model model){
        model.addAttribute("blog",this.blogService.findById(id));
        return "/detail";
    }
}
