package com.codegym.dto;

import com.codegym.models.entity.security.Role;

import java.util.List;

public class UserDto {
    private Long id;
    private String userName;
    private String passWord;
    private boolean isEnabled;
    private List<Role> roles;

    public UserDto(Long id, String userName, String passWord, boolean isEnabled, List<Role> roles) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.isEnabled = isEnabled;
        this.roles = roles;
    }

    public UserDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
