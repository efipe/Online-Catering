package com.brokul.cateringonline.configuration;

import com.brokul.cateringonline.model.AppUser;
import com.brokul.cateringonline.model.UserRole;
import com.brokul.cateringonline.repository.AppUserRepository;
import com.brokul.cateringonline.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {


        checkAndLoadRoles();
        checkAndLoadUsers();
    }

    private void checkAndLoadUsers() {
        if (!checkUser("admin")) {
            createUser("admin", "admin", "ROLE_USER", "ROLE_ADMIN");
        }
        // dodaj user'a!
        if (!checkUser("user")) {
            createUser("user", "user", "ROLE_USER");
        }
    }

    private void createUser(String username, String password, String... roles) {
//        AppUser appUser = new AppUser();
//        appUser.setUsername(username);
//        appUser.setPassword(password);

        // odnajdujemy w bazie danych wszystkie uprawnienia które należy nadać użytkownikowi
        Set<UserRole> userRoles = new HashSet<>();
        for (String role : roles) {
            userRoles.add(findRole(role));
            // zbieramy uprawnienia do setu
        }

        // tworzymy instancję użytkownika
        AppUser appUser = new AppUser();
        appUser.setRoles(userRoles);
        appUser.setPassword(bCryptPasswordEncoder.encode(password));
        appUser.setUsername(username);

        // zapisujemy instancję w bazie
        appUserRepository.saveAndFlush(appUser);
    }

    private UserRole findRole(String role) {
        UserRole userRole = userRoleRepository.getByName(role);
        return userRole;
    }

    private boolean checkUser(String username) {
        return appUserRepository.findByUsername(username).isPresent();
    }

    private void checkAndLoadRoles() {
        if (!checkRole("ROLE_USER")) {
          createRole("ROLE_USER");
        }
        if (!checkRole("ROLE_ADMIN")) {
            createRole("ROLE_ADMIN");
        }
        if (!checkRole("ROLE_SPY")) {
            createRole("ROLE_SPY");
        }
    }

    /**
     * 4
     * Tworzenie roli użytkownika.
     *
     * @param role - nazwa roli która ma być stworzona.
     */
    private void createRole(String role) {
        UserRole createdRole = new UserRole(null, role);
        userRoleRepository.save(createdRole);
    }

    /**
     * Sprawdzenie czy rola istnieje.
     *
     * @param role - nazwa roli która ma być sprawdzona.
     * @return - wynik true - jeśli rola istnieje, false jeśli nie.
     */
    private boolean checkRole(String role) {
        return userRoleRepository.findByName(role).isPresent();
    }


}
