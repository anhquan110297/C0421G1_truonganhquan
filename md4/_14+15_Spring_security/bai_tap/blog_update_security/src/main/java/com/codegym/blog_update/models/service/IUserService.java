package com.codegym.blog_update.models.service;

import java.util.List;
import com.codegym.blog_update.models.entities.security.MyUsers;


public interface IUserService {
    List < MyUsers > findAll();
    //    void save(User user);
//    void update(User user);
    MyUsers findById(Long id);
}
