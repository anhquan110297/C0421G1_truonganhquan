package com.codegym.models.services.security_service.impl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CreateBCryptPass {
    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("123"));
    }
}
