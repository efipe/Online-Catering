package com.brokul.cateringonline.service;

import com.brokul.cateringonline.model.AppUser;
import com.brokul.cateringonline.model.dto.AppUserDto;
import com.brokul.cateringonline.model.dto.UpdateAppUserDto;
import com.brokul.cateringonline.repository.AppUserRepository;
import com.brokul.cateringonline.repository.CateringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public boolean register(String username, String password) {
        AppUser appUser = new AppUser();
        appUser.setUsername(username);
            appUser.setPassword(bCryptPasswordEncoder.encode(password));
            appUser.getRoles().add(userRoleService.getUserRole());
            appUser.setRoles(new HashSet<>(Arrays.asList(userRoleService.getUserRole())));

            try {
                appUserRepository.saveAndFlush(appUser);
            } catch (ConstraintViolationException cve) {
                return false;
            }
        return true;
    }

    public boolean update(Long id, UpdateAppUserDto oldUserData) {
        Optional<AppUser> oldUserFromDb = appUserRepository.findById(id);
        if (oldUserFromDb.isPresent()) {
            AppUser updated = oldUserFromDb.get();
            if ((!oldUserData.getPassword().isEmpty()) && (oldUserData.getPasswordConfirm().equals(oldUserData.getPassword()))) {
                updated.setPassword(bCryptPasswordEncoder.encode(oldUserData.getPassword()));
            }
            updated.setEmail(oldUserData.getEmail());
            updated.setFirstName(oldUserData.getFirstName());
            updated.setLastName(oldUserData.getLastName());
            updated.setPostalCode(oldUserData.getPostalCode());
            updated.setCity(oldUserData.getCity());
            updated.setAddress(oldUserData.getAddress());
            updated.setPhoneNumber(oldUserData.getPhoneNumber());
            appUserRepository.save(updated);
            return true;
        }
        return false;
    }

    public List<AppUser> getAllUsers() {
        return appUserRepository.findAll();
    }

    public Optional<AppUser> findByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }
}

