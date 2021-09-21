package com.codegym.blog_update.models.entities.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyUserDetail implements UserDetails {
    private MyUsers myUsers;

    public MyUserDetail(MyUsers myUsers) {
        this.myUsers = myUsers;
    }

    @Override
    public Collection <? extends GrantedAuthority > getAuthorities() {
        List <GrantedAuthority> grantedAuthorities = new ArrayList <>();
        for(MyRole myRole : myUsers.getMyRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(myRole.getName()));
        }
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return myUsers.getPassWord();
    }

    @Override
    public String getUsername() {
        return myUsers.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return myUsers.isEnabled();
    }
}
