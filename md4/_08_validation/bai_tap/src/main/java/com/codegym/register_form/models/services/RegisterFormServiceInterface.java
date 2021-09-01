package com.codegym.register_form.models.services;

import com.codegym.register_form.models.entity.Users;

import java.util.List;

public interface RegisterFormServiceInterface {
    public List < Users > findAll();
    public void save(Users users);
}
