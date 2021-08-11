package models.bean.customer;

import models.bean.Person;

public class Customer extends Person {
    private int gender;
    private int customerTypeId;
    private String customerCode;

    public Customer() {
    }

    public Customer(String name, String birthDay, String idCard, String email, String phone, String address, int gender,
                    int customerTypeId, String customerCode) {
        super(name, birthDay, idCard, email, phone, address);
        this.gender = gender;
        this.customerTypeId = customerTypeId;
        this.customerCode = customerCode;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(int customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }
}
