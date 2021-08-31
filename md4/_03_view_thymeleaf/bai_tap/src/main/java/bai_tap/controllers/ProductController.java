package bai_tap.controllers;

import bai_tap.models.beans.Product;
import bai_tap.models.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping (value = "/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping(value = "/list")
    public String showProductList(Model model){
        List<Product> productList = productService.showList();
        model.addAttribute("productList",productList);
        return "view-list";
    }

    @GetMapping(value = "/create")
    public String showCreate(Model model){
        model.addAttribute("newProduct",new Product());
        return "create";
    }
    @PostMapping(value = "/create")
    public String create (@ModelAttribute Product newProduct
                            , Model model
                            , RedirectAttributes redirectAttributes){
        this.productService.save(newProduct);
        redirectAttributes.addFlashAttribute("hihi","Create new product success!");
        return "redirect:/product/list";
    }

    @GetMapping(value = "/remove/{id}")
    public String showDelete(Model model, @PathVariable int id){
        Product product = this.productService.detail(id);
        model.addAttribute("product",product);
        return "delete";
    }

    @PostMapping(value = "/remove")
    public String delete (Model model,RedirectAttributes redirectAttributes,@ModelAttribute Product product){
        this.productService.remove(product.getId());
        redirectAttributes.addFlashAttribute("msg","Delete product success!");
        return "redirect:/product/list";
    }

    @GetMapping(value = "edit/{id}")
    public String showEdit (@ModelAttribute Product product,Model model,@PathVariable int id){
        Product editProduct = this.productService.detail(id);
        model.addAttribute("product",editProduct);
        return "edit";
    }

    @PostMapping (value = "/edit")
    public String edit (Model model,RedirectAttributes redirect,@ModelAttribute Product product){
        this.productService.edit(product);
        return "redirect:/product/list";
    }

    @GetMapping (value = "/detail/{id}")
    public String showDetail (Model model,@PathVariable int id,@ModelAttribute Product product,RedirectAttributes redirect){
        model.addAttribute("product",this.productService.detail(id));
        return "detail";
    }




}
