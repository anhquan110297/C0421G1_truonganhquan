package com.codegym.controllers;

import com.codegym.dto.CustomerDto;
import com.codegym.models.entity.customer.Customer;
import com.codegym.models.services.customer.interfacee.ICustomerService;
import com.codegym.models.services.customer.interfacee.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
    @Autowired
    ICustomerService customerService;
    @Autowired
    ICustomerTypeService customerTypeService;


    @GetMapping(value = "/list")
    public String showList(@PageableDefault(value = 5) Pageable pageable, Model model) {
        model.addAttribute("customerList", this.customerService.findAll(pageable));
        return "customer-view/list";
    }

    @GetMapping(value = "/create")
    public String showCreate(Model model) {
        CustomerDto customerDto = new CustomerDto();
        model.addAttribute("customerDto", customerDto);
        model.addAttribute("customerTypeList", this.customerTypeService.findAll());
        return "customer-view/create";
    }

    @PostMapping(value = "/create")
    public String doCreate(@ModelAttribute("customerDto") @Valid CustomerDto customerDto,
                           BindingResult bindingResult, RedirectAttributes redirectAttributes,
                           Model model) {
        if (bindingResult.hasFieldErrors()) {
            //load lai du lieu
            model.addAttribute("customerTypeList", this.customerTypeService.findAll());
            return "customer-view/create";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("msg", "Create " + customerDto.getName() + " success!!!");
        return "redirect:/customer/list";

    }

    @GetMapping(value = "/edit/{id}")
    public String viewEdit(@PathVariable Long id, Model model) {
        model.addAttribute("customerDto", this.customerService.findById(id));
        model.addAttribute("customerTypeList", this.customerTypeService.findAll());
        return "customer-view/edit";
    }

    @PostMapping(value = "/edit")
    public String doEdit(@ModelAttribute("customerDto") @Valid CustomerDto customerDto
            , BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerTypeList", this.customerTypeService.findAll());
            return "customer-view/edit";
        }
        Customer employee = new Customer();
        BeanUtils.copyProperties(customerDto, employee);
        this.customerService.save(employee);
        redirectAttributes.addFlashAttribute("msg", "Update " + customerDto.getName() + " success!!!");
        return "redirect:/customer/list";
    }

}
