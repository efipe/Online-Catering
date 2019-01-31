package com.brokul.cateringonline.service;

import com.brokul.cateringonline.model.UserRole;
import com.brokul.cateringonline.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class UserRoleService {
    @Autowired
    private UserRoleRepository userRoleRepository;

    public UserRole getUserRole() {
        Optional<UserRole> optionalUserRole = userRoleRepository.findByName("ROLE_USER");
        if (optionalUserRole.isPresent()) {
            return optionalUserRole.get();
        }
        throw new DataIntegrityViolationException("USER_ROLE should exist in database");
    }
}

