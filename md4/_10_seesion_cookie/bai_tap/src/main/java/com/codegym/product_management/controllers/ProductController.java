package com.codegym.product_management.controllers;

import com.codegym.product_management.Dto.CartDto;
import com.codegym.product_management.Dto.ProductDto;
import com.codegym.product_management.models.entity.Product;
import com.codegym.product_management.models.services.IProductServices;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

@SessionAttributes("cart")
@Controller
public class ProductController {
    @Autowired
    IProductServices productServices;

    @ModelAttribute("cart")
    public CartDto initCart(){
        return new CartDto();
    }

    @GetMapping(value = {"", "/home"})
    public String viewList(Model model) {
        List < Product > productList = this.productServices.findAll();
        model.addAttribute("productList", productList);
        return "view";
    }

    @GetMapping(value = "/detail/{id}")
    public String viewDetail(@PathVariable int id, Model model) {
        model.addAttribute("product", this.productServices.findById(id));
        return "detail";
    }

    @GetMapping("/add/{id}")
    public String addToCart (@PathVariable int id, @SessionAttribute CartDto cart,Model model){
        Product product = productServices.findById(id);
        if (product != null){
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product,productDto);
            cart.addProductToCart(productDto);
            model.addAttribute("cart",cart);
        }
        return "view-cart";
    }

    @PostMapping (value = "/add")
    public String payment(@SessionAttribute CartDto cart, Model model, RedirectAttributes redirectAttributes){
        Map<ProductDto,Integer> cartMap = cart.getCartMap();
        cartMap.clear();
        model.addAttribute("msg","Thank for using");
        return "redirect:/home";
    }



}
