package com.codegym.models.repositories.security_repository;

import com.codegym.models.entity.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUserName(String name);
}
