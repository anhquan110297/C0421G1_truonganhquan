package com.codegym.models.services.security_service.interfacee;

import com.codegym.models.entity.security.User;


import java.util.List;

public interface UserService {
    List<User> findAll();
    void save(User user);
    User findById(int id);
}
