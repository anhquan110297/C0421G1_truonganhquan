package com.codegym.models.services.security_service.impl;

import com.codegym.models.entity.security.Role;
import com.codegym.models.repositories.security_repository.RoleRepository;
import com.codegym.models.services.security_service.interfacee.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleService implements IRoleService {
    @Autowired
    RoleRepository roleRepository;
    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role findRoleByName(String name) {
        return roleRepository.findRoleByName(name);
    }
}
