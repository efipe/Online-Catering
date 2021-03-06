package com.brokul.cateringonline.repository;

import com.brokul.cateringonline.model.AppUser;
import com.brokul.cateringonline.model.Catering;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {


    Optional<AppUser> findByUsername(String username);


}
