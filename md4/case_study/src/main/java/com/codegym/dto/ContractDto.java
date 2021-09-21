package com.codegym.dto;

import com.codegym.models.entity.contract.ContractDetail;
import com.codegym.models.entity.customer.Customer;
import com.codegym.models.entity.employee.Employee;
import com.codegym.models.entity.service.Service;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.List;

public class ContractDto {
    private Long id;
    @NotEmpty(message = "You must choose day")
    private String startDate;
    @NotEmpty(message = "You must choose day")
    private String endDate;
    @Min(value = 1,message = "Deposit must be positive")
    private double deposit;
    private Employee employee;
    private Customer customer;
    private Service service;
    private List<ContractDetail> contractDetails;
}
