package com.brokul.cateringonline.controller;

import com.brokul.cateringonline.model.AppUser;
import com.brokul.cateringonline.model.Catering;
import com.brokul.cateringonline.model.dto.AppUserDto;
import com.brokul.cateringonline.model.dto.UpdateAppUserDto;
import com.brokul.cateringonline.service.AppUserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/appUserPage/")
public class AppUserController {

    @Autowired
    private AppUserService appUserService;


//    @GetMapping("/appUserPage")
//    private String getUserPanelPage(){
//        return "/appUserPanel";
//    }

    @GetMapping("/updateUser")
    public String getUpdateUserPage(Model model) {
        // wyciaganie usera
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<AppUser> appUser = appUserService.findByUsername(user.getUsername());
        AppUser optionaAppuser = appUser.get();
        model.addAttribute("user", optionaAppuser);
        return "updateUserForm";
    }

    @GetMapping("/myOrderList")
    public String getMyOrdersListPage(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<AppUser> appUser = appUserService.findByUsername(user.getUsername());
        if (appUser.isPresent()) {
            AppUser optionalAppuser = appUser.get();
            List<Catering> cateringList = optionalAppuser.getListOfUserOrders();
            model.addAttribute("catering_user_list", cateringList);
            return "myOrders";
        }
        return "myOrders";
    }


    @PostMapping("/updateUser/{id}")
    public String update(@PathVariable(name = "id") Long id, UpdateAppUserDto appUserDto) {
        appUserService.update(id, appUserDto);
        return "redirect:/";
    }


}
