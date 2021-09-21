package com.codegym.dto;

import com.codegym.models.entity.contract.Contract;
import com.codegym.models.entity.employee.Division;
import com.codegym.models.entity.employee.EducationDegree;
import com.codegym.models.entity.employee.Position;

import javax.persistence.*;
import javax.validation.Validator;
import javax.validation.constraints.*;
import java.util.List;


public class EmployeeDto {
    private Long id;
    @NotEmpty(message = "Employee's name wrong type")
    private String name;
    @NotBlank (message = "Not be empty")
    private String birthday;
    @Pattern(regexp = "^(\\d{9}|\\d{10})$", message = "ID Card must be xxxxxxxxx (x is a number from 0 to 9)")
    private String idCard;
    @Min(value = 1,message = "Salary must be positive")
    private Double salary;
    @Pattern(regexp = "^(09[0-1]\\d{7})$",message = "Phone must be (+84XXXXXXXXX or 090XXXXXXX and X is a number) ")
    private String phone;
    @Email (message = "email is not valid")
    private String email;
    @NotBlank (message = "Not be empty")
    private String address;
//    @Pattern( regexp = "^KH-\\d{4}$", message = "Customer code must be KH-XXXX (X is a number)")
//    private String code;
    private Position position;
    private EducationDegree educationDegree;
    private Division division;
    private List<Contract> contracts;

    public EmployeeDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}