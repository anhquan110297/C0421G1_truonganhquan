package com.codegym.blog_update.models.service.impl;

import com.codegym.blog_update.models.entities.security.MyUsers;
import com.codegym.blog_update.models.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import com.codegym.blog_update.models.repositories.MyUsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MyUserServiceimpl implements IUserService {

    @Autowired
    MyUsersRepository myUsersRepository;

    @Override
    public List< MyUsers > findAll() {
        return myUsersRepository.findAll();
    }

    @Override
    public MyUsers findById(Long id) {
        return myUsersRepository.findById(id).get();
    }
}
