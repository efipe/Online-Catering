package com.brokul.cateringonline.repository;

import com.brokul.cateringonline.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    Optional<UserRole> findByName(String role_user);

    UserRole getByName(String role);
}

