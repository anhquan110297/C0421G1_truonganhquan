package com.codegym.models.repositories.security_repository;

import com.codegym.models.entity.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findRoleByName (String name);
}
