package com.codegym.register_form.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UsersDto {
    private int id;
    @Size (min = 5,max = 45, message = "First name must be at least 5 characters and not more than 45 characters ")
    private String firstName;
    @Size (min = 5,max = 45, message = "Last name must be at least 5 characters and not more than 45 characters ")
    private String lastName;
    @Pattern(regexp = "(84|0[3|5|7|8|9])+([0-9]{8})\\b",message = "\n" +
            "must start by +84 or 0 ")
    private String phoneNumber;
    @Min(value = 18, message = "Min age is 18")
    private int age;
   @Email(message = "Please enter email")
    private String email;

    public UsersDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
