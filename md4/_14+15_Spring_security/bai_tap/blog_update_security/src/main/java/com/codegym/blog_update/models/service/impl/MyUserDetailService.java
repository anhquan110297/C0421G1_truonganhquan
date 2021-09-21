package com.codegym.blog_update.models.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.codegym.blog_update.models.repositories.MyUsersRepository;
import com.codegym.blog_update.models.entities.security.MyUsers;
import com.codegym.blog_update.models.entities.security.MyUserDetail;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private MyUsersRepository myUsersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUsers user = myUsersRepository.findByUserName(username);

        if(user == null){
            throw new UsernameNotFoundException("User name: "+ username + " not found.");
        }

        return new MyUserDetail(user);
    }
}
