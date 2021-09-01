package com.codegym.register_form.models.repositories;

import com.codegym.register_form.models.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterFormRepositoryInterface extends JpaRepository < Users,Integer > {
}
