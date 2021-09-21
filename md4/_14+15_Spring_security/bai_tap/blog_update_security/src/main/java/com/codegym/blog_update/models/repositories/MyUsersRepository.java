package com.codegym.blog_update.models.repositories;

import com.codegym.blog_update.models.entities.security.MyUsers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyUsersRepository extends JpaRepository< MyUsers,Long> {
    MyUsers findByUserName(String name);

}
