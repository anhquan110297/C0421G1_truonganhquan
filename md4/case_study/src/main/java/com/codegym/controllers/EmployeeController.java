package com.codegym.controllers;

import com.codegym.dto.EmployeeDto;
import com.codegym.models.entity.employee.Employee;
import com.codegym.models.services.employee.Interfacee.IDivisionService;
import com.codegym.models.services.employee.Interfacee.IEducationDegreeService;
import com.codegym.models.services.employee.Interfacee.IEmployeeService;
import com.codegym.models.services.employee.Interfacee.IPositionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {
    @Autowired
    IEmployeeService employeeService;
    @Autowired
    IDivisionService divisionService;
    @Autowired
    IEducationDegreeService educationDegreeService;
    @Autowired
    IPositionService positionService;


    @GetMapping(value = "/list")
    public String showList(@PageableDefault(value = 5) Pageable pageable, Model model,
                           @RequestParam(value = "searchByName" ,required = false) String name) {
        if (name != null) {
            Page<Employee> employeePage = employeeService.search(name, pageable);
            model.addAttribute("name",name);
            model.addAttribute("employeeList", employeePage);
            return "employee-view/list";
        } else {
            model.addAttribute("employeeList", employeeService.showList(pageable));
            return "employee-view/list";
        }
    }

    @GetMapping(value = "/create")
    public String showCreate(Model model) {
        EmployeeDto employeeDto = new EmployeeDto();
        model.addAttribute("employeeDto", employeeDto);
        model.addAttribute("divisionList", divisionService.findAll());
        model.addAttribute("educationDegreeList", educationDegreeService.findAll());
        model.addAttribute("positionList", positionService.findAll());
        return "employee-view/create";
    }

    @PostMapping(value = "/create")
    public String doCreate(@ModelAttribute("employeeDto") @Valid EmployeeDto employeeDto,
                           BindingResult bindingResult, RedirectAttributes redirectAttributes,
                           Model model) {
        if (bindingResult.hasFieldErrors()) {
            //load lai du lieu
            initCreate(model);
            return "employee-view/create";
        } else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            employeeService.save(employee);
            redirectAttributes.addFlashAttribute("msg", "Create " + employeeDto.getName() + " success!!!");
            return "redirect:/employee/list";
        }
    }

    @GetMapping(value = "/edit/{id}")
    public String viewEdit(@PathVariable Long id, Model model) {
        model.addAttribute("employeeDto", this.employeeService.findById(id));
        initCreate(model);
        return "employee-view/edit";
    }

    @PostMapping(value = "/edit")
    public String doEdit(@ModelAttribute("employeeDto") @Valid EmployeeDto employeeDto
            , BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            initCreate(model);
            return "employee-view/edit";
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        this.employeeService.save(employee);
        redirectAttributes.addFlashAttribute("msg", "Update" + employeeDto.getName() + " success!!!");
        return "redirect:/employee/list";
    }

    @PostMapping("/delete")
    public String doDelete(@RequestParam(value = "employeeId") long id,RedirectAttributes redirectAttributes){
        Employee employee = this.employeeService.findById(id);
        this.employeeService.delete(employee);
        redirectAttributes.addFlashAttribute("msg","Delete success!!!");
        return "redirect:/employee/list";
    }

//    @PostMapping(value = "/search")
//    public String showListSearch(@PageableDefault(value = 5) Pageable pageable, Model model,
//                                 @RequestParam(value = "searchByName") String name) {
//Page<Employee> employeePage = employeeService.search(name,pageable);
//        model.addAttribute("employeeList",employeePage);
//        return "employee-view/list";
//    }


    private void initCreate(Model model) {
        model.addAttribute("divisionList", divisionService.findAll());
        model.addAttribute("educationDegreeList", educationDegreeService.findAll());
        model.addAttribute("positionList", positionService.findAll());
    }


}
