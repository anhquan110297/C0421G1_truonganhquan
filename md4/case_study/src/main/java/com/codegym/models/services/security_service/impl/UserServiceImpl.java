package com.codegym.models.services.security_service.impl;

import com.codegym.models.entity.security.User;
import com.codegym.models.repositories.security_repository.UserRepository;
import com.codegym.models.services.security_service.interfacee.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User findById(int id) {
        return null;
    }
}
