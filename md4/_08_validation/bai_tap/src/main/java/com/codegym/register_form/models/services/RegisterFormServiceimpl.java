package com.codegym.register_form.models.services;

import com.codegym.register_form.models.entity.Users;
import com.codegym.register_form.models.repositories.RegisterFormRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterFormServiceimpl implements RegisterFormServiceInterface {
    @Autowired
    RegisterFormRepositoryInterface repositoryInterface;

    @Override
    public List < Users > findAll() {
        return repositoryInterface.findAll();
    }

    @Override
    public void save(Users users) {
        repositoryInterface.save(users);
    }
}
