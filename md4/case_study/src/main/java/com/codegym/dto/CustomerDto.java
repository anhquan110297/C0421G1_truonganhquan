package com.codegym.dto;

import com.codegym.models.entity.contract.Contract;
import com.codegym.models.entity.customer.CustomerType;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

public class CustomerDto {
    private Long id;
    @NotNull(message = "You must input something")
    private String name;
    private CustomerType customerType;
    private String birthday;
    private boolean gender;
    @NotNull(message = "You must input something")
    @Pattern(regexp = "^(\\d{9}|\\d{10})$", message = "Incorrect, try again. Id Card must bbe xxxxxxxxx (X is a number)" )
    private String idCard;
    @NotNull(message = "You must input something")
    @Pattern(regexp = "^(09[0-1]\\d{7})$", message = "Incorrect. Must :090-xxxxxxx or 091-xxxxxxx")
    private String phone;
    @Email
    private String email;
    @NotBlank(message = "You must input something")
    private String address;
    @NotNull(message = "You must input something")
    @Pattern(regexp = "^KH-\\d{4}$", message = "Incorrect. Ex:KH-xxxx. x is number")
    private String code;
    private List<Contract> contracts;

    public CustomerDto() {
    }

    public CustomerDto(Long id, String name, CustomerType customerType, String birthday, boolean gender, String idCard,
                       String phone, String email, String address, String code, List<Contract> contracts) {
        this.id = id;
        this.name = name;
        this.customerType = customerType;
        this.birthday = birthday;
        this.gender = gender;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.code = code;
        this.contracts = contracts;
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

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}
