package com.codegym.models.services.security_service.interfacee;

import com.codegym.models.entity.security.Role;

import java.util.List;

public interface IRoleService {
    List<Role> findAll ();
    Role findRoleByName (String name);
}
