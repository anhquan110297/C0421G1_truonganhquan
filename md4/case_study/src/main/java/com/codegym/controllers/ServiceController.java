package com.codegym.controllers;

import com.codegym.dto.CustomerDto;
import com.codegym.dto.ServiceDto;
import com.codegym.models.entity.customer.Customer;
import com.codegym.models.entity.service.Service;
import com.codegym.models.services.service.interfacee.IRentTypeService;
import com.codegym.models.services.service.interfacee.IServiceService;
import com.codegym.models.services.service.interfacee.IServiceTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping (value = "/service")
public class ServiceController {
    @Autowired
    IRentTypeService rentTypeService;
    @Autowired
    IServiceService serviceService;
    @Autowired
    IServiceTypeService serviceTypeService;


    @GetMapping(value = "/list")
    public String showList(@PageableDefault(value = 5) Pageable pageable, Model model) {
        model.addAttribute("serviceList",this.serviceService.findAll(pageable));
        return "service-view/list";
    }

    @GetMapping(value = "/create")
    public String showCreate(Model model) {
        ServiceDto serviceDto = new ServiceDto();
        model.addAttribute("serviceDto", serviceDto);
        model.addAttribute("rentTypeList",this.rentTypeService.findAll() );
        model.addAttribute("serviceTypeList", this.serviceTypeService.findAll());
        return "service-view/create";
    }

    @PostMapping(value = "/create")
    public String doCreate(@ModelAttribute("serviceDto") @Valid ServiceDto serviceDto,
                           BindingResult bindingResult, RedirectAttributes redirectAttributes,
                           Model model) {
        if (bindingResult.hasFieldErrors()) {
            //load lai du lieu
            model.addAttribute("rentTypeList",this.rentTypeService.findAll() );
            model.addAttribute("serviceTypeList", this.serviceTypeService.findAll());
            return "service-view/create";
        }
        Service service = new Service();
        BeanUtils.copyProperties(serviceDto, service);
        serviceService.save(service);
        redirectAttributes.addFlashAttribute("msg", "Create " + serviceDto.getName() + " success!!!");
        return "redirect:/service/list";

    }
}
