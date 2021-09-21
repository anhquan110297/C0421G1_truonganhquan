package com.codegym.dto;

import com.codegym.models.entity.security.User;

import javax.persistence.ManyToMany;
import java.util.Set;

public class RoleDto {
    private Long id;
    private String name;
    private Set<User> users;
}
